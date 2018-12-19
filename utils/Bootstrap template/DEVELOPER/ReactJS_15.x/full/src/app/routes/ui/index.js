import React from 'react';
import HtmlRender from '../../components/utils/HtmlRender'

export default {
  path: 'ui',
  component: require('../../components/common/Layout').default,

  childRoutes: [
    {
      path: 'buttons',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/buttons.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'grid',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/grid.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'typography',
      getComponent(nextState, cb){
        System.import('html-loader?-attrs!./content/typography.html').then((html)=> {
          cb(null,
            () => (<HtmlRender html={html}/>)
          )
        })
      }
    },
    {
      path: 'tree-views',
      getComponent(nextState, cb){
        System.import('./containers/TreeViews').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'general',
      getComponent(nextState, cb){
        System.import('./containers/UiGeneral').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'nestable-lists',
      getComponent(nextState, cb){
        System.import('./containers/NestableLists').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'jquery-ui',
      getComponent(nextState, cb){
        System.import('./containers/JQueryUi').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'font-awesome',
      getComponent(nextState, cb){
        System.import('./containers/icons/FontAwesomeIcons').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'flags',
      getComponent(nextState, cb){
        System.import('./containers/icons/FlagIcons').then((m)=> {
          cb(null, m.default)
        })
      }
    },
    {
      path: 'glyphicons',
      getComponent(nextState, cb){
        System.import('./containers/icons/Glyphicons').then((m)=> {
          cb(null, m.default)
        })
      }
    },

  ]


};
