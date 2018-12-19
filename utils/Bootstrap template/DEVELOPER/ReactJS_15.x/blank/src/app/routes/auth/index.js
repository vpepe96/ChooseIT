import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  childRoutes: [
    {
      path: 'lock',
      getComponent(nextState, cb){
        System.import('./containers/LockedScreen').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'login',
      getComponent(nextState, cb){
        System.import('./containers/Login').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'register',
      getComponent(nextState, cb){
        System.import('./containers/Register').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'forgot',
      getComponent(nextState, cb){
        System.import('./containers/Forgot').then((m)=> {
          cb(null, m.default)
        })
      }
    }
  ]
};
