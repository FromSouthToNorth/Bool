$.ajaxPrefilter(function (options, originalOptions, jqXHR) {
  options.xhrFields = {
    withCredentials: true
  }
    options.crossDomain = true
  options.beforeSend = XMLHttpRequest => {
    XMLHttpRequest.setRequestHeader("token", "MyToken");
  }
  options.url = "https://hyzt.vip:8081/" + originalOptions.url
});
