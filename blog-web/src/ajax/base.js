$.ajaxPrefilter(function (options, originalOptions, jqXHR) {
  options.xhrFields = {
    withCredentials: true
  }
    options.crossDomain = true
  options.beforeSend = XMLHttpRequest => {
    XMLHttpRequest.setRequestHeader("token", "MyToken");
  }
  options.url = "http://47.102.212.117:8081/" + originalOptions.url
});