$.ajaxPrefilter(function (options, originalOptions, jqXHR) {
  options.xhrFields = {
    withCredentials: true
  }
    options.crossDomain = true
  options.beforeSend = XMLHttpRequest => {
    XMLHttpRequest.setRequestHeader("token", "MyToken");
  }
  options.url = "http://127.0.0.1:8081/" + originalOptions.url
});