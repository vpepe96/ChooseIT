import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  path: 'misc',
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'email-template',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/email-template.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'invoice',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/invoice.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'pricing-tables',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/pricing-tables.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'search',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/search.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },

    {
      path: 'blank',
      getComponent(nextState, cb){
        System.import('./containers/BlankPage').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: '404',
      getComponent(nextState, cb){
        System.import('./containers/Page404').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: '500',
      getComponent(nextState, cb){
        System.import('./containers/Page500').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'ck-editor',
      getComponent(nextState, cb){
        System.import('./containers/CKEditorDemo').then((m)=> {
          cb(null, m.default)
        })
      }
    },


  ]


};
