/**
 * Created by griga on 11/17/16.
 */

import {config} from '../../config/config'

import * as layout from './LayoutActions'


const initialState = {
  smartSkin: localStorage.getItem('sm-skin') || config.smartSkin,
  skin: config.skins.find((_skin) => {
    return _skin.name == (localStorage.getItem('sm-skin') || config.smartSkin)
  }),
  skins: config.skins,
  fixedHeader: localStorage.getItem('sm-fixed-header') == 'true',
  fixedNavigation: localStorage.getItem('sm-fixed-navigation') == 'true',
  fixedRibbon: localStorage.getItem('sm-fixed-ribbon') == 'true',
  fixedPageFooter: localStorage.getItem('sm-fixed-page-footer') == 'true',
  insideContainer: localStorage.getItem('sm-inside-container') == 'true',
  rtl: localStorage.getItem('sm-rtl') == 'true',
  menuOnTop: localStorage.getItem('sm-menu-on-top') == 'true',
  colorblindFriendly: localStorage.getItem('sm-colorblind-friendly') == 'true',

  shortcutOpen: false,
  isMobile: (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase())),
  device: '',

  mobileViewActivated: false,
  menuCollapsed: false,
  menuMinified: false,
};


export default function layoutReducer(state = initialState, action) {
  let _state;

  switch (action.type) {

    case layout.SMART_SKIN:
      _state = {...state};
      _state.skin = action.skin;
      _state.smartSkin = action.skin.name;

      return _state;

    case layout.TOGGLE_FIXED_HEADER:
      _state = {...state};
      _state.fixedHeader = !_state.fixedHeader;
      if (_state.fixedHeader == false) {
        _state.fixedRibbon = false;
        _state.fixedNavigation = false;
      }

      return _state;


    case layout.TOGGLE_FIXED_NAVIGATION:
      _state = {...state};
      _state.fixedNavigation = !_state.fixedNavigation;

      if (_state.fixedNavigation) {
        _state.insideContainer = false;
        _state.fixedHeader = true;
      } else {
        _state.fixedRibbon = false;
      }

      return _state;


    case layout.TOGGLE_FIXED_RIBBON:
      _state = {...state};
      _state.fixedRibbon = !_state.fixedRibbon;
      if (_state.fixedRibbon) {
        _state.fixedHeader = true;
        _state.fixedNavigation = true;
        _state.insideContainer = false;
      }

      return _state;


    case layout.TOGGLE_FIXED_PAGE_FOOTER:
      _state = {...state};
      _state.fixedPageFooter = !_state.fixedPageFooter;

      return _state;


    case layout.TOGGLE_INSIDE_CONTAINER:
      _state = {...state};
      _state.insideContainer = !_state.insideContainer;
      if (_state.insideContainer) {
        _state.fixedRibbon = false;
        _state.fixedNavigation = false;
      }

      return _state;


    case layout.TOGGLE_RTL:
      _state = {...state};
      _state.rtl = !_state.rtl;

      return _state;


    case layout.TOGGLE_MENU_ON_TOP:
      _state = {...state};
      _state.menuOnTop = !_state.menuOnTop;

      return _state;


    case layout.TOGGLE_COLORBLIND_FRIENDLY:
      _state = {...state};
      _state.colorblindFriendly = !_state.colorblindFriendly;
      return _state;

    case layout.TOGGLE_COLLAPSE_MENU:
      _state = {...state};
      if (typeof value !== 'undefined') {
        _state.menuCollapsed = value
      } else {
        _state.menuCollapsed = !_state.menuCollapsed;
      }

      return _state;


    case layout.TOGGLE_MENU_MINIFIED:
      _state = {...state};
      _state.menuMinified = !_state.menuMinified;

      return _state;

    case layout.TOGGLE_SHORTCUT:
      _state = {...state};
      _state.shortcutOpen = !_state.shortcutOpen;


      return _state;


    default:
      return state;
  }
}