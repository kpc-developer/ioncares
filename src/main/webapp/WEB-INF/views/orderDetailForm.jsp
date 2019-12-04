<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="author" content=""/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.png"/>
    <link rel="stylesheet" href="/assets/css/admin_style.css" />
    <script type="text/javascript" src="/assets/js/lib/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="/assets/js/lib/underscore-min.js"></script>
    <script type="text/javascript" src="/assets/js/lib/handlebars-v4.0.5.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.css">
    <script type="text/javascript" src="/assets/js/lib/requirejs/require.min.js"></script>
    <script type="text/javascript" src="/assets/js/admin/require.config.js"></script>
    <script type="text/javascript" src="/assets/js/lib/jquery/jquery.min.js"></script>
    <title>발주 상세정보</title>
</head>
<body>
    <section class="list-page">
        <div class="form-inline search-form">
        <form id="searchForm" name="searchForm" method="post" action="" onsubmit="return false;">
            <input type="hidden" id="client" name="client" value="${param.client }">
            <input type="hidden" id="orderNumber" name="orderNumber" value="${param.orderNumber }">
            <a href="#" class="btn btn-success btn-sm btn-back">
                <i class="fa fa-search mgr5"></i> 뒤로가기
            </a>
        </form>
        </div>
        <hr />
        <section class="mgt40">
            <h4 class="pdl20">
                <i class="fa fa-list mgr5"></i>발주 상세정보(${param.client } - ${param.orderNumber})
            </h4>
            <table class="table table-bordered table-hover data-table mgt20">
                <colgroup>
                	<col style="width:100px" />
                    <col style="width:250px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                   
                </colgroup>
                <thead>
                    <tr class="bg-primary">
                    	<th class="text-center">번호</th>
                        <th class="text-center">품명</th>
                        <th class="text-center">규격</th>
                        <th class="text-center">수량</th>
                        <th class="text-center">단위</th>
                        <th class="text-center">단가</th>
                    </tr>
                </thead>
                <tbody id="contents"></tbody>
            </table>
        </section>
    </section>
    <script type="text/javascript">
		requirejs([ 'orderDetailForm' ]);
	</script>
    <script id="list_template" type="text/x-handlebars-template">
    {{#dataList}}
        <tr class="text-center">
			<td>{{productNumber}}</td>
			<td>{{productName}}</td>
            <td>{{standard}}</td>
			<td>{{count}}</td>
            <td>{{unit}}</td>
			<td>{{price}}</td>
        </tr>
    {{else}}
        <tr>
            <td colspan="6" class="no-data">
                <i class="fa fa-exclamation-triangle mgr5"></i> 검색된 데이터가 없습니다.
            </td>
        </tr>
    {{/dataList}}
    </script> 
</body>
</html>

  