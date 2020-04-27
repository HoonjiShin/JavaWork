package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {

	public static final String REQ_SERVICE ="SPOP_DAILYSUM_JACHI";
	public static final String API_KEY = "4d46796d7366726f3833774a774955";
	public static void main(String[] args) throws IOException {
		System.out.println("자치구단위 서울 생활인구 일별 집계표");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("날짜입력 : ");
		String date = sc.nextLine();
		System.out.print("시작Index :");
		int startIndex = sc.nextInt();
		System.out.print("Index :");
		int endIndex = sc.nextInt();
		
		
		String url = buildUrlAddress(startIndex,endIndex,date);
		
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements =doc.select("row");
		System.out.println("[XML]");
		System.out.println("  날짜            \t구ID        총생활인구수           일최대이동인구수");
		
		for(Element e:elements) {
			String STDR_DE_ID = 
					e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE =
					e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = 
					e.selectFirst("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO = 
					e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			System.out.printf("%10s \t %10s \t %15s \t %12s\n",
					STDR_DE_ID,SIGNGU_CODE_SE,TOT_LVPOP_CO,DAIL_MXMM_MVMN_LVPOP_CO);
		}
		ObjectMapper mapper = new ObjectMapper();
	
		String name = String.format("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/%d/%d/%s"
									,startIndex,endIndex,date);
		URL url2 = new URL(name);
		
		Daily daily = mapper.readValue(url2, Daily.class);

		System.out.println("[JSON]");
		System.out.println("  날짜            \t구ID        총생활인구수           일최대이동인구수");
	
		
		for(DayRow e : daily.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%10s \t %10s \t %15s \t %12s\n",
					e.getStdr(),
					e.getSigngu(),
					e.getTotal(),
					e.getDailymax()
					);
		}
		System.out.println("\n프로그램 종료");
	} // end main

	public static String buildUrlAddress(int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/%d/%d/%s",
				startIndex, endIndex, date);

		return url_address;
		
	} 
	
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Daily{
	public Sum SPOP_DAILYSUM_JACHI;

	public Sum getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}
	public void setSPOP_DAILYSUM_JACHI(Sum sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}
	
	}

@JsonIgnoreProperties(ignoreUnknown = true)
class Sum{
	
	private int list_total_count;
	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}

	private List<DayRow> row;

	public List<DayRow> getRow() {return row;}

	public Sum() {
		super();
	}
	
	public void setRow(List<DayRow> row) {this.row = row;}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class DayRow{
	@JsonProperty("STDR_DE_ID")
	private String Stdr;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String Signgu;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String Total;
	
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String Dailymax;
	
	public DayRow() {super();}

	public String getStdr() {
		return Stdr;
	}

	public void setStdr(String stdr) {
		this.Stdr = stdr;
	}

	public String getSigngu() {
		return Signgu;
	}

	public void setSigngu(String signgu) {
		this.Signgu = signgu;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		this.Total = total;
	}

	public String getDailymax() {
		return Dailymax;
	}

	public void setDailymax(String dailymax) {
		this.Dailymax = dailymax;
	}
	
	
}































