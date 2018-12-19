import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  path: 'e-commerce',
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'products-detail',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/products-detail.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'products-view',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/products-view.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },

    {
      path: 'orders',
      getComponent(nextState, cb){
        System.import('./containers/Orders').then((m)=> {
          cb(null, m.default)
        })
      }
    },


  ]


};
