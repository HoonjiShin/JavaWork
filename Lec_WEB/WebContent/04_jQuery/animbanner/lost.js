(function(){
    // 바다
    var $waterFront = $("#water-front");
    var $waterBack = $("#water-back");

    (function loopSea(){
        $waterFront
            .animate({'bottom' : '-65px', 'left' : '-30px'}, 500)
            .animate({'bottom' : '-60px', 'left' : '-25px'}, 500);

        $waterBack
            .animate({'bottom' : '15px', 'left' : '-20px'}, 500)
            .animate({'bottom' : '10px', 'left' : '-25px'}, 500);
            
        $.when($waterFront, $waterBack).done(loopSea);   
    })();

    // 구름
    var $cloud1 = $('#cloud-group-1');
    var $cloud2 = $('#cloud-group-2');

    (function loopCloud(){
        $cloud1
            .animate({'left' : '-720px'}, 10000)
            .animate({'left' : '0px'}, 0);
        $cloud2
            .animate({'left' : '0px'}, 10000)
            .animate({'left' : '720px'}, 0,loopCloud);

           // $.when($cloud1, $cloud2).done(loopCloud);   

    })();
    



})()