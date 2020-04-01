<!DOCTYPE html>
<html>
    <head>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src="rpc/brutusin-rpc.js"></script>
        <script language='javascript'>
            var http = brutusin["rpc"].initHttpEndpoint("<%=request.getContextPath() + org.brutusin.rpc.RpcConfig.getInstance().getPath()+"/http"%>");
            var wskt = brutusin["rpc"].initWebsocketEndpoint("<%=request.getContextPath() + org.brutusin.rpc.RpcConfig.getInstance().getPath()+"/wskt"%>");
        </script>
        <script language='javascript'>
            http.ajax({
                service: "rpc.http.version",
                load: function (response) {
                    alert(JSON.stringify(response));
                }
            });
        </script>
    </head>
    <body>
		<h1>
            <div ng-app="">
              <p>Name : <input type="text" ng-model="name"></p>
              <h1>Hello {{name}}</h1>
            </div>
		</h1>
		
        <h1>Congratulations PHX TEAM!</h1> You have successfully created a Brutusin-RPC war application</h1>
    <div>The functional testing module is accessible <a href="rpc/repo">here</a></div>
</body>
</html>
