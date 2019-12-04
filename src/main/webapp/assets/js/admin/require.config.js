require.config({
    baseUrl: '/assets/js/admin/',
    urlArgs : 'ts=' + (new Date()).getTime(),
    waitSeconds: 15,
    paths: {
        'jquery': '/assets/js/lib/jquery/jquery.min',
        'jquery-ui': '/assets/js/lib/jquery/jquery-ui.min',
        'moment': '/assets/js/lib/moment/moment-with-locales.min',
        'underscore': '/assets/js/lib/underscore/underscore-min',
        
        'bootstrap': '/assets/js/lib/bootstrap/bootstrap.min',
        
        'amcharts': '/assets/js/lib/amcharts/amcharts',
        'amcharts-serial': '/assets/js/lib/amcharts/serial',
        
        'handlebars': '/assets/js/lib/handlebars/handlebars-v4.0.5',
    	'handlebars-helpers': '/assets/js/lib/handlebars/handlebars-helpers'
    },

    shim:{
        'jquery': { exports: '$' },
        'jquery-ui': [ 'jquery' ],
        'underscore': { exports: '_' },
        
        'bootstrap': ['jquery'],
        
        'amcharts': { exports: 'AmCharts', deps:['jquery'] },
        'amcharts-serial': { exports: 'AmCharts', deps:['jquery','amcharts'] },
        
        'handlebars': ['jquery'],
        'handlebars-helpers': ['handlebars','moment','underscore']
    }
});