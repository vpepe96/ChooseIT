import React from 'react'

import HtmlRender from '../../../components/utils/HtmlRender'

const html = require('html-loader?-attrs!./SocialWall.html')

export default ()=>(<HtmlRender html={html} />)
