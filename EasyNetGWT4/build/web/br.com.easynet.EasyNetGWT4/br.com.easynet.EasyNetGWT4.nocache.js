function br_com_easynet_EasyNetGWT4(){
  var $intern_0 = 'bootstrap', $intern_1 = 'begin', $intern_2 = 'gwt.codesvr.br.com.easynet.EasyNetGWT4=', $intern_3 = 'gwt.codesvr=', $intern_4 = 'br.com.easynet.EasyNetGWT4', $intern_5 = 'startup', $intern_6 = 'DUMMY', $intern_7 = 0, $intern_8 = 1, $intern_9 = 'iframe', $intern_10 = 'javascript:""', $intern_11 = 'position:absolute; width:0; height:0; border:none; left: -1000px;', $intern_12 = ' top: -1000px;', $intern_13 = 'CSS1Compat', $intern_14 = '<!doctype html>', $intern_15 = '', $intern_16 = '<html><head><\/head><body><\/body><\/html>', $intern_17 = 'undefined', $intern_18 = 'readystatechange', $intern_19 = 10, $intern_20 = 'script', $intern_21 = 'javascript', $intern_22 = 'br_com_easynet_EasyNetGWT4', $intern_23 = 'Failed to load ', $intern_24 = 'moduleStartup', $intern_25 = 'scriptTagAdded', $intern_26 = 'moduleRequested', $intern_27 = 'meta', $intern_28 = 'name', $intern_29 = 'br.com.easynet.EasyNetGWT4::', $intern_30 = '::', $intern_31 = 'gwt:property', $intern_32 = 'content', $intern_33 = '=', $intern_34 = 'gwt:onPropertyErrorFn', $intern_35 = 'Bad handler "', $intern_36 = '" for "gwt:onPropertyErrorFn"', $intern_37 = 'gwt:onLoadErrorFn', $intern_38 = '" for "gwt:onLoadErrorFn"', $intern_39 = '#', $intern_40 = '?', $intern_41 = '/', $intern_42 = 'img', $intern_43 = 'clear.cache.gif', $intern_44 = 'baseUrl', $intern_45 = 'br.com.easynet.EasyNetGWT4.nocache.js', $intern_46 = 'base', $intern_47 = '//', $intern_48 = 'selectingPermutation', $intern_49 = 'br.com.easynet.EasyNetGWT4.devmode.js', $intern_50 = '72E3D9A0CC6FFA955AFE071BB4A4A584', $intern_51 = ':', $intern_52 = '.cache.js', $intern_53 = 'link', $intern_54 = 'rel', $intern_55 = 'stylesheet', $intern_56 = 'href', $intern_57 = 'head', $intern_58 = 'loadExternalRefs', $intern_59 = 'bootstrap3/vendor/bootstrap/css/bootstrap.min.css', $intern_60 = 'bootstrap3/vendor/metisMenu/metisMenu.min.css', $intern_61 = 'bootstrap3/vendor/datatables-plugins/dataTables.bootstrap.css', $intern_62 = 'bootstrap3/vendor/datatables-responsive/dataTables.responsive.css', $intern_63 = 'bootstrap3/dist/css/sb-admin-2.min.css', $intern_64 = 'bootstrap3/vendor/font-awesome/css/font-awesome.min.css', $intern_65 = 'bootstrap3/dist/css/menu.css', $intern_66 = 'bootstrap3/dist/css/menuaccordion.css', $intern_67 = 'bootstrap3/datetimepicker/css/bootstrap-datetimepicker.min.css', $intern_68 = 'bootstrap3/datetimepicker/css/gijgo.min.css', $intern_69 = 'gm/navcustom.css', $intern_70 = 'end', $intern_71 = 'http:', $intern_72 = 'file:', $intern_73 = '_gwt_dummy_', $intern_74 = '__gwtDevModeHook:br.com.easynet.EasyNetGWT4', $intern_75 = 'Ignoring non-whitelisted Dev Mode URL: ', $intern_76 = ':moduleBase';
  var $wnd = window;
  var $doc = document;
  sendStats($intern_0, $intern_1);
  function isHostedMode(){
    var query = $wnd.location.search;
    return query.indexOf($intern_2) != -1 || query.indexOf($intern_3) != -1;
  }

  function sendStats(evtGroupString, typeString){
    if ($wnd.__gwtStatsEvent) {
      $wnd.__gwtStatsEvent({moduleName:$intern_4, sessionId:$wnd.__gwtStatsSessionId, subSystem:$intern_5, evtGroup:evtGroupString, millis:(new Date).getTime(), type:typeString});
    }
  }

  br_com_easynet_EasyNetGWT4.__sendStats = sendStats;
  br_com_easynet_EasyNetGWT4.__moduleName = $intern_4;
  br_com_easynet_EasyNetGWT4.__errFn = null;
  br_com_easynet_EasyNetGWT4.__moduleBase = $intern_6;
  br_com_easynet_EasyNetGWT4.__softPermutationId = $intern_7;
  br_com_easynet_EasyNetGWT4.__computePropValue = null;
  br_com_easynet_EasyNetGWT4.__getPropMap = null;
  br_com_easynet_EasyNetGWT4.__installRunAsyncCode = function(){
  }
  ;
  br_com_easynet_EasyNetGWT4.__gwtStartLoadingFragment = function(){
    return null;
  }
  ;
  br_com_easynet_EasyNetGWT4.__gwt_isKnownPropertyValue = function(){
    return false;
  }
  ;
  br_com_easynet_EasyNetGWT4.__gwt_getMetaProperty = function(){
    return null;
  }
  ;
  var __propertyErrorFunction = null;
  var activeModules = $wnd.__gwt_activeModules = $wnd.__gwt_activeModules || {};
  activeModules[$intern_4] = {moduleName:$intern_4};
  br_com_easynet_EasyNetGWT4.__moduleStartupDone = function(permProps){
    var oldBindings = activeModules[$intern_4].bindings;
    activeModules[$intern_4].bindings = function(){
      var props = oldBindings?oldBindings():{};
      var embeddedProps = permProps[br_com_easynet_EasyNetGWT4.__softPermutationId];
      for (var i = $intern_7; i < embeddedProps.length; i++) {
        var pair = embeddedProps[i];
        props[pair[$intern_7]] = pair[$intern_8];
      }
      return props;
    }
    ;
  }
  ;
  var frameDoc;
  function getInstallLocationDoc(){
    setupInstallLocation();
    return frameDoc;
  }

  function setupInstallLocation(){
    if (frameDoc) {
      return;
    }
    var scriptFrame = $doc.createElement($intern_9);
    scriptFrame.src = $intern_10;
    scriptFrame.id = $intern_4;
    scriptFrame.style.cssText = $intern_11 + $intern_12;
    scriptFrame.tabIndex = -1;
    $doc.body.appendChild(scriptFrame);
    frameDoc = scriptFrame.contentDocument;
    if (!frameDoc) {
      frameDoc = scriptFrame.contentWindow.document;
    }
    frameDoc.open();
    var doctype = document.compatMode == $intern_13?$intern_14:$intern_15;
    frameDoc.write(doctype + $intern_16);
    frameDoc.close();
  }

  function installScript(filename){
    function setupWaitForBodyLoad(callback){
      function isBodyLoaded(){
        if (typeof $doc.readyState == $intern_17) {
          return typeof $doc.body != $intern_17 && $doc.body != null;
        }
        return /loaded|complete/.test($doc.readyState);
      }

      var bodyDone = isBodyLoaded();
      if (bodyDone) {
        callback();
        return;
      }
      function checkBodyDone(){
        if (!bodyDone) {
          if (!isBodyLoaded()) {
            return;
          }
          bodyDone = true;
          callback();
          if ($doc.removeEventListener) {
            $doc.removeEventListener($intern_18, checkBodyDone, false);
          }
          if (onBodyDoneTimerId) {
            clearInterval(onBodyDoneTimerId);
          }
        }
      }

      if ($doc.addEventListener) {
        $doc.addEventListener($intern_18, checkBodyDone, false);
      }
      var onBodyDoneTimerId = setInterval(function(){
        checkBodyDone();
      }
      , $intern_19);
    }

    function installCode(code_0){
      var doc = getInstallLocationDoc();
      var docbody = doc.body;
      var script = doc.createElement($intern_20);
      script.language = $intern_21;
      script.src = code_0;
      if (br_com_easynet_EasyNetGWT4.__errFn) {
        script.onerror = function(){
          br_com_easynet_EasyNetGWT4.__errFn($intern_22, new Error($intern_23 + code_0));
        }
        ;
      }
      docbody.appendChild(script);
      sendStats($intern_24, $intern_25);
    }

    sendStats($intern_24, $intern_26);
    setupWaitForBodyLoad(function(){
      installCode(filename);
    }
    );
  }

  br_com_easynet_EasyNetGWT4.__startLoadingFragment = function(fragmentFile){
    return computeUrlForResource(fragmentFile);
  }
  ;
  br_com_easynet_EasyNetGWT4.__installRunAsyncCode = function(code_0){
    var doc = getInstallLocationDoc();
    var docbody = doc.body;
    var script = doc.createElement($intern_20);
    script.language = $intern_21;
    script.text = code_0;
    docbody.appendChild(script);
  }
  ;
  function processMetas(){
    var metaProps = {};
    var propertyErrorFunc;
    var onLoadErrorFunc;
    var metas = $doc.getElementsByTagName($intern_27);
    for (var i = $intern_7, n = metas.length; i < n; ++i) {
      var meta = metas[i], name_0 = meta.getAttribute($intern_28), content;
      if (name_0) {
        name_0 = name_0.replace($intern_29, $intern_15);
        if (name_0.indexOf($intern_30) >= $intern_7) {
          continue;
        }
        if (name_0 == $intern_31) {
          content = meta.getAttribute($intern_32);
          if (content) {
            var value_0, eq = content.indexOf($intern_33);
            if (eq >= $intern_7) {
              name_0 = content.substring($intern_7, eq);
              value_0 = content.substring(eq + $intern_8);
            }
             else {
              name_0 = content;
              value_0 = $intern_15;
            }
            metaProps[name_0] = value_0;
          }
        }
         else if (name_0 == $intern_34) {
          content = meta.getAttribute($intern_32);
          if (content) {
            try {
              propertyErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_35 + content + $intern_36);
            }
          }
        }
         else if (name_0 == $intern_37) {
          content = meta.getAttribute($intern_32);
          if (content) {
            try {
              onLoadErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_35 + content + $intern_38);
            }
          }
        }
      }
    }
    __gwt_getMetaProperty = function(name_0){
      var value_0 = metaProps[name_0];
      return value_0 == null?null:value_0;
    }
    ;
    __propertyErrorFunction = propertyErrorFunc;
    br_com_easynet_EasyNetGWT4.__errFn = onLoadErrorFunc;
  }

  function computeScriptBase(){
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf($intern_39);
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf($intern_40);
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf($intern_41, Math.min(queryIndex, hashIndex));
      return slashIndex >= $intern_7?path.substring($intern_7, slashIndex + $intern_8):$intern_15;
    }

    function ensureAbsoluteUrl(url_0){
      if (url_0.match(/^\w+:\/\//)) {
      }
       else {
        var img = $doc.createElement($intern_42);
        img.src = url_0 + $intern_43;
        url_0 = getDirectoryOfFile(img.src);
      }
      return url_0;
    }

    function tryMetaTag(){
      var metaVal = __gwt_getMetaProperty($intern_44);
      if (metaVal != null) {
        return metaVal;
      }
      return $intern_15;
    }

    function tryNocacheJsTag(){
      var scriptTags = $doc.getElementsByTagName($intern_20);
      for (var i = $intern_7; i < scriptTags.length; ++i) {
        if (scriptTags[i].src.indexOf($intern_45) != -1) {
          return getDirectoryOfFile(scriptTags[i].src);
        }
      }
      return $intern_15;
    }

    function tryBaseTag(){
      var baseElements = $doc.getElementsByTagName($intern_46);
      if (baseElements.length > $intern_7) {
        return baseElements[baseElements.length - $intern_8].href;
      }
      return $intern_15;
    }

    function isLocationOk(){
      var loc = $doc.location;
      return loc.href == loc.protocol + $intern_47 + loc.host + loc.pathname + loc.search + loc.hash;
    }

    var tempBase = tryMetaTag();
    if (tempBase == $intern_15) {
      tempBase = tryNocacheJsTag();
    }
    if (tempBase == $intern_15) {
      tempBase = tryBaseTag();
    }
    if (tempBase == $intern_15 && isLocationOk()) {
      tempBase = getDirectoryOfFile($doc.location.href);
    }
    tempBase = ensureAbsoluteUrl(tempBase);
    return tempBase;
  }

  function computeUrlForResource(resource){
    if (resource.match(/^\//)) {
      return resource;
    }
    if (resource.match(/^[a-zA-Z]+:\/\//)) {
      return resource;
    }
    return br_com_easynet_EasyNetGWT4.__moduleBase + resource;
  }

  function getCompiledCodeFilename(){
    var answers = [];
    var softPermutationId = $intern_7;
    var values = [];
    var providers = [];
    function computePropValue(propName){
      var value_0 = providers[propName](), allowedValuesMap = values[propName];
      if (value_0 in allowedValuesMap) {
        return value_0;
      }
      var allowedValuesList = [];
      for (var k in allowedValuesMap) {
        allowedValuesList[allowedValuesMap[k]] = k;
      }
      if (__propertyErrorFunction) {
        __propertyErrorFunction(propName, allowedValuesList, value_0);
      }
      throw null;
    }

    __gwt_isKnownPropertyValue = function(propName, propValue){
      return propValue in values[propName];
    }
    ;
    br_com_easynet_EasyNetGWT4.__getPropMap = function(){
      var result = {};
      for (var key in values) {
        if (values.hasOwnProperty(key)) {
          result[key] = computePropValue(key);
        }
      }
      return result;
    }
    ;
    br_com_easynet_EasyNetGWT4.__computePropValue = computePropValue;
    $wnd.__gwt_activeModules[$intern_4].bindings = br_com_easynet_EasyNetGWT4.__getPropMap;
    sendStats($intern_0, $intern_48);
    if (isHostedMode()) {
      return computeUrlForResource($intern_49);
    }
    var strongName;
    try {
      strongName = $intern_50;
      var idx = strongName.indexOf($intern_51);
      if (idx != -1) {
        softPermutationId = parseInt(strongName.substring(idx + $intern_8), $intern_19);
        strongName = strongName.substring($intern_7, idx);
      }
    }
     catch (e) {
    }
    br_com_easynet_EasyNetGWT4.__softPermutationId = softPermutationId;
    return computeUrlForResource(strongName + $intern_52);
  }

  function loadExternalStylesheets(){
    if (!$wnd.__gwt_stylesLoaded) {
      $wnd.__gwt_stylesLoaded = {};
    }
    function installOneStylesheet(stylesheetUrl){
      if (!__gwt_stylesLoaded[stylesheetUrl]) {
        var l = $doc.createElement($intern_53);
        l.setAttribute($intern_54, $intern_55);
        l.setAttribute($intern_56, computeUrlForResource(stylesheetUrl));
        $doc.getElementsByTagName($intern_57)[$intern_7].appendChild(l);
        __gwt_stylesLoaded[stylesheetUrl] = true;
      }
    }

    sendStats($intern_58, $intern_1);
    installOneStylesheet($intern_59);
    installOneStylesheet($intern_60);
    installOneStylesheet($intern_61);
    installOneStylesheet($intern_62);
    installOneStylesheet($intern_63);
    installOneStylesheet($intern_64);
    installOneStylesheet($intern_65);
    installOneStylesheet($intern_66);
    installOneStylesheet($intern_67);
    installOneStylesheet($intern_68);
    installOneStylesheet($intern_69);
    sendStats($intern_58, $intern_70);
  }

  processMetas();
  br_com_easynet_EasyNetGWT4.__moduleBase = computeScriptBase();
  activeModules[$intern_4].moduleBase = br_com_easynet_EasyNetGWT4.__moduleBase;
  var filename = getCompiledCodeFilename();
  if ($wnd) {
    var devModePermitted = !!($wnd.location.protocol == $intern_71 || $wnd.location.protocol == $intern_72);
    $wnd.__gwt_activeModules[$intern_4].canRedirect = devModePermitted;
    function supportsSessionStorage(){
      var key = $intern_73;
      try {
        $wnd.sessionStorage.setItem(key, key);
        $wnd.sessionStorage.removeItem(key);
        return true;
      }
       catch (e) {
        return false;
      }
    }

    if (devModePermitted && supportsSessionStorage()) {
      var devModeKey = $intern_74;
      var devModeUrl = $wnd.sessionStorage[devModeKey];
      if (!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(devModeUrl)) {
        if (devModeUrl && (window.console && console.log)) {
          console.log($intern_75 + devModeUrl);
        }
        devModeUrl = $intern_15;
      }
      if (devModeUrl && !$wnd[devModeKey]) {
        $wnd[devModeKey] = true;
        $wnd[devModeKey + $intern_76] = computeScriptBase();
        var devModeScript = $doc.createElement($intern_20);
        devModeScript.src = devModeUrl;
        var head = $doc.getElementsByTagName($intern_57)[$intern_7];
        head.insertBefore(devModeScript, head.firstElementChild || head.children[$intern_7]);
        return false;
      }
    }
  }
  loadExternalStylesheets();
  sendStats($intern_0, $intern_70);
  installScript(filename);
  return true;
}

br_com_easynet_EasyNetGWT4.succeeded = br_com_easynet_EasyNetGWT4();
