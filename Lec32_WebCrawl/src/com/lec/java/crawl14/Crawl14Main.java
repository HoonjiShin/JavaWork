package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 
 * */

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json -> Java");
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001");
		
		Subway subway = mapper.readValue(url, Subway.class);

		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());

		for (SubRow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
					e.getLineNum(), 
					e.getStationName(), 
					e.getRidePassenger(), 
					e.getAlightPassenger());
		}

		System.out.println("\n프로그램종료");

	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	public Stats CardSubwayStatsNew;

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stats {
	
	private int list_total_count;
	
	private List<SubRow> row;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	public List<SubRow> getRow() {
		return row;
	}

	public void setRow(List<SubRow> row) {
		this.row = row;
	}
}

//JSON 필드명과 매핑되는 Java 객체의 변수명을 달리하고 싶다면
//@JsonProperty 사용

@JsonIgnoreProperties(ignoreUnknown = true) //명시되어있지 않은 변수는 무시하겠다. 없으면 에러남.
class SubRow {
	
	@JsonProperty("LINE_NUM")
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassenger;
	
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassenger;

	public String getLineNum() {return lineNum;}
	public String getStationName() {return stationName;}
	public void setLineNum(String lineNum) {this.lineNum = lineNum;}
	public void setStationName(String stationName) {this.stationName = stationName;}
	public int getRidePassenger() {return ridePassenger;}
	public void setRidePassenger(int ridePassenger) {this.ridePassenger = ridePassenger;}
	public int getAlightPassenger() {return alightPassenger;}
	public void setAlightPassenger(int alightPassenger) {this.alightPassenger = alightPassenger;}
	
}
