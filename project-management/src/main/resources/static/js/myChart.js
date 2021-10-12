var niceChartData = decodeHtml(chartData);
var jsonChartData = JSON.parse(niceChartData);
var arrayLength = jsonChartData.length;
var counts = [];
var stages = [];

for(var i =0; i<arrayLength; i++){
	counts[i] = jsonChartData[i].count;
	stages[i] = jsonChartData[i].stage;
}

var myPieChart = new Chart(document.getElementById("myPieChart"),{
    type: 'pie',
     data: {
        labels: stages,
        datasets: [{
            label: "My First dataset",
            backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f"],
            borderColor: 'rgb(255, 99, 132)',
            data: counts
        }]
    },

    // Configuration options go here
    options: {
	 title:{
		display:true,
		text: 'Project statuses'
	}
}
});


function decodeHtml(html){
	var text = document.createElement("textarea");
	text.innerHTML= html;
	return text.value;
}