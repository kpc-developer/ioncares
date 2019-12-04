define(
	    [
	        'jquery',
	        'underscore',
	        'moment',
	        'handlebars',
	        
	        'bootstrap',
	        'jquery-ui',
	        'handlebars-helpers'
	    ],
	    function( $, _, moment, Handlebars )
	    {
	        'use strict';

	        
	        function loadDataList( )
	        {
	        	
	        	$.ajax({
	        		url: '/api/getOrderList',
	        		method: 'POST',
	        		data: { 
	        			
	        			
	        		},
	        		dataType: 'json',
	        		success: function(data){
	        			console.log(data);
	        			var source = $("#list_template").html(); //핸들바 템플릿 가져오기 
	        			
	        			var template = Handlebars.compile(source); //핸들바 템플릿 컴파일 

	                    var html = template(data.result); //핸들바 템플릿에 데이터를 바인딩해서 HTML 생성
	        			
	        			$("#contents").html(html);  //생성된 HTML을 DOM에 주입
	        			
	        			//displayPagenation( data.result );
	        		}
	        	})
	        }

	        
	        $(function(){
	        	loadDataList();
	        });
	    }
	);