var consulta = $("#searchTable").DataTable();

$("#inputBusqueda").keyup(function(){
	consulta.search($(this).val()).draw();

	$("header").css({
		"height": "100vh",
		"background": "rgba(0,0,0,0.5)"
	})

	if ($("#inputBusqueda").val() == ""){
		$("header").css({
			"height": "auto",
			"background": "none"
		})

		$("#search").hide()

	} else {
		$("#search").fadeIn("fast");
	}
})


const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')

if (toastTrigger) {
  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
  toastTrigger.addEventListener('click', () => {
    toastBootstrap.show()
  })
}