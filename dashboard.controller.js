(function () {
    'use strict';

    angular
        .module('app')
        .controller('dashboardPageController', dashboardPageController);

    dashboardPageController.$inject = ['DashboardService', '$rootScope'];
    function dashboardPageController(DashboardService, $rootScope) {
        var vm = this;
        vm.obj = null;
        vm.rows={};
        vm.y={};
        vm.records=[];
        vm.productionMonth=null;
        vm.postedStartDateTime=null;
        vm.electionEndDateTime=null;
        vm.postedEndDateTime=null;
        
        vm.getDashboardData = getDashboardData;
        vm.getJsDate=getJsDate;
        vm.isFutureDate=isFutureDate;
        vm.submit = submit;

        initController();

        function initController() {
        	getDashboardData();
        }

        function getDashboardData() {
        	DashboardService.getDashboardData()
                .then(function (obj) {
                	console.log(obj);
                	vm.records = obj.data;
                    vm.productionMonth=obj.data.productionMonth;
                    vm.postedStartDateTime=obj.data.postedStartDateandTime;
                    vm.electionEndDateTime=obj.data.electionDateandTime;
                    vm.postedEndDateTime=obj.data.postedEndDateandTime;
                   
                    var postedEndDateTime='2017-12-28T04:00:000+0000';
                    var dateTime = getJsDate(postedEndDateTime);
                    console.log("dateTime:"+dateTime);
                    console.log("updated..:"+dateTime.setMonth(dateTime.getMonth()+1));
                    console.log("updated..:"+dateTime);
                    var isFuture = isFutureDate(dateTime);
                    console.log("isFuture:"+isFuture);
                    console.log("added one month"+dateTime.getFullYear()+""+dateTime.getMonth()+1);
                    /*console.log("productionMonth:"+vm.productionMonth);
                    console.log("postedStartDateTime:"+vm.postedStartDateTime);
                    console.log("electionEndDateTime:"+vm.electionEndDateTime);
                    console.log("postedEndDateTime:"+vm.postedEndDateTime);*/
                });
        }
        
        function submit(){
        	console.log(vm);
        	console.log(vm.y);
        	var data = new Array();
        	var isValid=true; 
        	var i=0;
        	angular.forEach(vm.y, function(value, key) {
        		i= i+1;
        		console.log(key + ': ' + value);
            	    var boj = value;
            	    console.log(boj);
            	    if(isValid){
            	    	 if(boj.hasOwnProperty("postingDate")){
                	    	 if(boj.hasOwnProperty("r1c2")){
                	    		 if(boj.hasOwnProperty("r1c3")){
                	    			 if(boj.hasOwnProperty("r1c4")){
                	    				 if(boj.hasOwnProperty("r1c5")){
                	    					 if(boj.hasOwnProperty("r1c6")){
                	    		        	    	console.log('all field are valid in row.:'+i);
                	    		        	    	isValid = true;
                	    		        	    	data.push(boj);
                	    		        	    }else{
                	    		        	    	isValid=false;
                	    		        	    	alert('Please enter value in Posting End Time in row :'+(i));
                	    		        	    }
                	    	        	    }else{
                	    	        	    	isValid=false;
                	    	        	    	alert('Please enter value in Posting End Date in row :'+(i));
                	    	        	    }
                	         	    }else{
                	         	    	isValid=false;
                	         	    	alert('Please enter value in Posting End Time in row :'+(i));
                	         	    }
                	        	    }else{
                	        	    	isValid=false;
                	        	    	alert('Please enter value in Election End Date in row :'+(i));
                	        	    }
                     	    }else{
                     	    	isValid=false;
                     	    	alert('Please enter value in Posting Start Time in row  :'+(i));
                     	    }
                	    }else{
                	    	isValid=false;
                	    	alert('Please enter value in Posting Start Date in row :'+(i));
                	    }
            	    }
            	    
        		});
        	if(isValid){
        		alert('form valid');
        		console.log(data);
        		DashboardService.postData(data)
                .then(function (obj) {
                	console.log(obj);
                	
                });
        		
        	}else{
        		alert('form is invalid, please enter all detials');
        	}
        	console.log(isValid);
        	
        };
        function getJsDate( dateTime ) {

        	var dateTime = dateTime.split("T");//dateTime[0] = date, dateTime[1] = time

        	var date = dateTime[0].split("-");
        	var time = dateTime[1].split(":");

        	//(year, month, day, hours, minutes, seconds, milliseconds)
        	//subtract 1 from month because Jan is 0 and Dec is 11
        	return new Date(date[0], (date[1]-1), date[2], time[0], time[1], 0, 0);

        	}
        function isFutureDate(dateTime){
        	var now = new Date();
        	var future = false;
        	console.log("now..:"+now);
        	console.log("dateTime..:"+dateTime);
        	if( Date.parse(now) < Date.parse(dateTime) ) {
        		future = true;
        	}
        	return future;
        }
    }

})();