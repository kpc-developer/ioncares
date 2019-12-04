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
    <title>주문정보</title>
</head>
<body>
    <section class="list-page">
        <section class="mgt40">
            <h4 class="pdl20">
                <i class="fa fa-list mgr5"></i>주문정보 ㄸ
            </h4>
            <table class="table table-bordered table-hover data-table mgt20">
                <colgroup>
                    <col style="width:150px" />
                    <col style="width:200px" />
                    <col style="width:150px" />
                    <col style="width:200px" />
                    <col style="width:100px" />
                    <col style="width:150px" />
                    <col style="width:150px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:100px" />
                    <col style="width:150px" />
                    <col style="width:150px" />
                    <col style="width:300px" />
                    <col style="width:100px" />
                    <col style="width:150px" />
                </colgroup>
                <thead>
                    <tr class="bg-primary">
                        <th class="text-center">회사</th>
                        <th class="text-center">발주번호</th>
                        <th class="text-center">이메일</th>
                        <th class="text-center">발주일자</th>
                        <th class="text-center">발주금액</th>
                        <th class="text-center">전자세금계산서</th>
                        <th class="text-center">납기일자</th>
                        <th class="text-center">납품장소</th>
                        <th class="text-center">지불조건</th>
                        <th class="text-center">담당부서</th>
                        <th class="text-center">담당자</th>
                        <th class="text-center">직책</th>
                        <th class="text-center">연락처</th>
                        <th class="text-center">발주처</th>
                        <th class="text-center">주소</th>
                        <th class="text-center">담당자명</th>
                        <th class="text-center">발주처 연락처</th>
                    </tr>
                </thead>
                <tbody id="contents"></tbody>
            </table>
            
            <div id="pagingDiv" class="text-center disableSelection">
                <nav>
                    <ul id="pagination" class="pagination pagination-sm"></ul>
                </nav>
            </div>
        </section>
    </section>
    <script type="text/javascript">
		requirejs([ 'orderListForm' ]);
	</script>
    <script id="list_template" type="text/x-handlebars-template">
    {{#dataList}}
        <tr class="text-center">
			<td>{{client}}</td>
            <td><a href="orderDetail?client={{client}}&orderNumber={{orderNumber}}">{{orderNumber}}</a></td>
			<td>{{email}}</td>
			<td>{{orderDate}}</td>
			<td>{{orderPrice}}</td>
			<td>{{taxBill}}</td>
			<td>{{deliveryDate}}</td>
			<td>{{deliveryPlace}}</td>
			<td>{{paymentOption}}</td>
			<td>{{department}}</td>			
			<td>{{manager}}</td>
            <td>{{position}}</td>
			<td>{{deliveryTel}}</td>
			<td>{{owner}}</td>
			<td>{{address}}</td>
			<td>{{ownerManager}}</td>
			<td>{{ownerTel}}</td>
        </tr>
    {{else}}
        <tr>
            <td colspan="17" class="no-data">
                <i class="fa fa-exclamation-triangle mgr5"></i> 검색된 데이터가 없습니다.
            </td>
        </tr>
    {{/dataList}}
    </script>
</body>
</html>

  