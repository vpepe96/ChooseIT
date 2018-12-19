import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  path: 'smartadmin',
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'app-layouts',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/app-layouts.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'skins',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/skins.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
  ]


};
