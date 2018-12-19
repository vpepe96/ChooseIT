import {SmartMessageBox} from "../utils/actions/MessageActions";
import {bodyAddClass, bodyToggleClass, bodyRemoveClass, htmlToggleClass, htmlRemoveClass} from "../utils/actions/rootContainers";
/**
 * Created by griga on 11/17/16.
 */


export const SMART_SKIN = 'SMART_SKIN';
export const TOGGLE_FIXED_HEADER = 'TOGGLE_FIXED_HEADER';
export const TOGGLE_FIXED_NAVIGATION = 'TOGGLE_FIXED_NAVIGATION';
export const TOGGLE_FIXED_RIBBON = 'TOGGLE_FIXED_RIBBON';
export const TOGGLE_FIXED_PAGE_FOOTER = 'TOGGLE_FIXED_PAGE_FOOTER';
export const TOGGLE_INSIDE_CONTAINER = 'TOGGLE_INSIDE_CONTAINER';
export const TOGGLE_RTL = 'TOGGLE_RTL';
export const TOGGLE_MENU_ON_TOP = 'TOGGLE_MENU_ON_TOP';
export const TOGGLE_COLORBLIND_FRIENDLY = 'TOGGLE_COLORBLIND_FRIENDLY';
export const TOGGLE_MENU_MINIFIED = 'TOGGLE_MENU_MINIFIED';
export const TOGGLE_SHORTCUT = 'TOGGLE_SHORTCUT';
export const TOGGLE_COLLAPSE_MENU = 'TOGGLE_COLLAPSE_MENU';
export const FACTORY_RESET = 'FACTORY_RESET';


export function onSmartSkin(skin) {
  return {
    type: SMART_SKIN,
    skin
  }
}


export function onFixedHeader() {
  return {
    type: TOGGLE_FIXED_HEADER
  }
}


export function onFixedNavigation() {
  return {
    type: TOGGLE_FIXED_NAVIGATION
  }
}


export function onFixedRibbon() {
  return {
    type: TOGGLE_FIXED_RIBBON
  }
}


export function onFixedPageFooter() {
  return {
    type: TOGGLE_FIXED_PAGE_FOOTER
  }
}


export function onInsideContainer() {
  return {
    type: TOGGLE_INSIDE_CONTAINER
  }
}


export function onRtl() {
  return {
    type: TOGGLE_RTL
  }
}


export function onMenuOnTop() {
  return {
    type: TOGGLE_MENU_ON_TOP
  }
}


export function onColorblindFriendly() {
  return {
    type: TOGGLE_COLORBLIND_FRIENDLY
  }
}


export function toggleMenuMinified() {
  return {
    type: TOGGLE_MENU_MINIFIED
  }
}

export function onCollapseMenu() {
  return {
    type: TOGGLE_COLLAPSE_MENU
  }
}


export function onToggleShortcut() {
  return {
    type: TOGGLE_SHORTCUT
  }
}


export const handleBodyClasses = store => next => action => {
  // console.log('dispatching', action)
  let result = next(action);


  const layout = store.getState().layout;

  bodyRemoveClass(layout.skins.map((it)=>(it.name)).join(' '));
  if(layout.skin){
    bodyAddClass(layout.skin.name);
    $("#logo img").attr('src', layout.skin.logo);
  }


  bodyToggleClass('fixed-header', layout.fixedHeader);
  bodyToggleClass('fixed-navigation', layout.fixedNavigation);
  bodyToggleClass('fixed-ribbon', layout.fixedRibbon);
  bodyToggleClass('fixed-page-footer', layout.fixedPageFooter);
  bodyToggleClass('container', layout.insideContainer);
  bodyToggleClass('smart-rtl', layout.rtl);
  bodyToggleClass('menu-on-top', layout.menuOnTop);
  bodyToggleClass('colorblind-friendly', layout.colorblindFriendly);
  bodyToggleClass('shortcut-on', layout.shortcutOpen);


  layout.mobileViewActivated = $(window).width() < 979;
  bodyToggleClass('mobile-view-activated', layout.mobileViewActivated);
  if (layout.mobileViewActivated) {
    bodyRemoveClass('minified');
  }

  if (layout.isMobile) {
    bodyAddClass("mobile-detected");
  } else {
    bodyAddClass("desktop-detected");
  }

  if (layout.menuOnTop) bodyRemoveClass('minified');


  if (!layout.menuOnTop) {
    htmlToggleClass("hidden-menu-mobile-lock", layout.menuCollapsed);
    bodyToggleClass("hidden-menu", layout.menuCollapsed);
    bodyRemoveClass("minified");
  } else if (layout.menuOnTop && layout.mobileViewActivated) {
    htmlToggleClass("hidden-menu-mobile-lock", layout.menuCollapsed);
    bodyToggleClass("hidden-menu", layout.menuCollapsed);
    bodyRemoveClass("minified");
  }

  if (layout.menuMinified && !layout.menuOnTop && !layout.mobileViewActivated) {
    bodyAddClass("minified");
    bodyRemoveClass("hidden-menu");
    htmlRemoveClass("hidden-menu-mobile-lock");
  }

  return result
};


export const dumpLayoutToStorage = store => next => action => {
  const result = next(action);
  const layout = store.getState().layout;
  localStorage.setItem('sm-skin', layout.smartSkin);
  localStorage.setItem('sm-fixed-header', layout.fixedHeader);
  localStorage.setItem('sm-fixed-navigation', layout.fixedNavigation);
  localStorage.setItem('sm-fixed-ribbon', layout.fixedRibbon);
  localStorage.setItem('sm-fixed-page-footer', layout.fixedPageFooter);
  localStorage.setItem('sm-inside-container', layout.insideContainer);
  localStorage.setItem('sm-rtl', layout.rtl);
  localStorage.setItem('sm-menu-on-top', layout.menuOnTop);
  localStorage.setItem('sm-colorblind-friendly', layout.colorblindFriendly);
  return result
};

export function factoryReset(){
  return dispatch => {
    SmartMessageBox({
      title: "<i class='fa fa-refresh' style='color:green'></i> Clear Local Storage",
      content: "Would you like to RESET all your saved widgets and clear LocalStorage?",
      buttons: '[No][Yes]'
    }, (ButtonPressed) => {
      if (ButtonPressed == "Yes" && localStorage) {
        localStorage.clear();
        location.reload()
        dispatch({
          type: FACTORY_RESET
        })
      }
    });
  }

}