define(
    [
        'jquery',
        'underscore',
        'moment',
        'handlebars'
    ],
    function( $, _, moment, Handlebars )
    {
        'use strict';

	    // trim() 함수 재정의 - IE8
	    if(typeof String.prototype.trim !== 'function') {
	        String.prototype.trim = function() {
	            return this.replace(/^\s+|\s+$/g, '');
	        };
	    }
	
	    // index 값 1증가하여 반환
	    Handlebars.registerHelper('counter', function (index){
	        return index + 1;
	    });
	
	    //moment 날짜 포멧
	    Handlebars.registerHelper('dateFormat', function (date, format) {
	        var mmnt = moment(date);
	        return mmnt.format(format);
	    });
	
	    //empty 체크
	    Handlebars.registerHelper('ifEmpty', function (data, options) {
	        if (data === undefined || data == null || data == "") {
	            return options.fn(this);
	        }
	        return options.inverse(this);
	    });
	
	    // equals 체크
	    Handlebars.registerHelper('ifCond', function (v1, operator, v2, options) {
	        switch (operator) {
	            case '==':
	                return (v1 == v2) ? options.fn(this) : options.inverse(this);
	            case '===':
	                return (v1 === v2) ? options.fn(this) : options.inverse(this);
	            case '!=':
	                return (v1 != v2) ? options.fn(this) : options.inverse(this);
	            case '!==':
	                return (v1 !== v2) ? options.fn(this) : options.inverse(this);
	            case '<':
	                return (v1 < v2) ? options.fn(this) : options.inverse(this);
	            case '<=':
	                return (v1 <= v2) ? options.fn(this) : options.inverse(this);
	            case '>':
	                return (v1 > v2) ? options.fn(this) : options.inverse(this);
	            case '>=':
	                return (v1 >= v2) ? options.fn(this) : options.inverse(this);
	            case '&&':
	                return (v1 && v2) ? options.fn(this) : options.inverse(this);
	            case '||':
	                return (v1 || v2) ? options.fn(this) : options.inverse(this);
	            default:
	                return options.inverse(this);
	        }
	    });
	
	    // 수학함수
	    Handlebars.registerHelper('math', function (v1, operator, v2, options) {
	        v1 = parseFloat(v1);
	        v2 = parseFloat(v2);
	
	        return {
	            '+': v1 + v2,
	            '-': v1 - v2,
	            '*': v1 * v2,
	            '/': v1 / v2,
	            '%': v1 % v2
	        }[operator];
	    });
	
	    //for 반복문
	    Handlebars.registerHelper('for', function (from, to, incr, block) {
	        var accum = '';
	        for (var i = from; i <= to; i += incr)
	            accum += block.fn(i);
	        return accum;
	    });
	
	    //천단위 콤마 표시하기
	    Handlebars.registerHelper('NumberComma', function (val) {
	        if( val != null ){
	            var sign = (val.toString().substring(0, 1) == "-" ? "-" : "");
	            var comma = sign + val.toString().replace(sign, "").split(/(?=(?:\d{3})+(?:\.|$))/g).join(',');
	            return comma;
	            
	        } else{
	            return '';
	        }
	    });

    }
);