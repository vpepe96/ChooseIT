import React from 'react';

import {bindActionCreators} from 'redux'

import {connect} from 'react-redux';

import classnames from 'classnames'

import {config} from '../../../config/config';

import * as LayoutActions from '../LayoutActions'



class LayoutSwitcher extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      isActivated : false
    }
  }

  onToggle = ()=> {
    this.setState({
      isActivated: !this.state.isActivated
    })
  };


  render(){
    return (
      <div className={classnames('demo', {
        'activate': this.state.isActivated
      })} >
				<span id="demo-setting"  onClick={this.onToggle}>
			    	<i className="fa fa-cog txt-color-blueDark"/>
			    </span>
        <form>
          <legend className="no-padding margin-bottom-10">Layout Options</legend>
          <section>
            <label><input type="checkbox" checked={this.props.fixedHeader} onChange={this.props.onFixedHeader}
                          className="checkbox style-0"/><span>Fixed Header</span></label>
            <label><input type="checkbox"
                          checked={this.props.fixedNavigation} onChange={this.props.onFixedNavigation}
                          className="checkbox style-0"/><span>Fixed Navigation</span></label>
            <label><input type="checkbox"
                          checked={this.props.fixedRibbon} onChange={this.props.onFixedRibbon}
                          className="checkbox style-0"/><span>Fixed Ribbon</span></label>
            <label><input type="checkbox"
                          checked={this.props.fixedPageFooter} onChange={this.props.onFixedPageFooter}
                          className="checkbox style-0"/><span>Fixed Footer</span></label>
            <label><input type="checkbox"
                          checked={this.props.insideContainer} onChange={this.props.onInsideContainer}
                          className="checkbox style-0"/><span>Inside <b> .container</b></span></label>
            <label><input type="checkbox"
                          checked={this.props.rtl} onChange={this.props.onRtl}
                          className="checkbox style-0"/><span>RTL</span></label>
            <label><input type="checkbox"
                          checked={this.props.menuOnTop} onChange={this.props.onMenuOnTop}
                          className="checkbox style-0"/><span>Menu on <b>top</b></span></label>
            <label><input type="checkbox"
                          checked={this.props.colorblindFriendly} onChange={this.props.onColorblindFriendly}
                          className="checkbox style-0"/><span>For Colorblind <div
              className="font-xs text-right">(experimental)
                        </div></span>
            </label><span id="smart-bgimages"/></section>
          <section><h6 className="margin-top-10 semi-bold margin-bottom-5">Clear Localstorage</h6><a
            onClick={this.props.factoryReset} className="btn btn-xs btn-block btn-primary"
            id="reset-smart-widget"><i
            className="fa fa-refresh"/> Factory Reset</a></section>

          <h6 className="margin-top-10 semi-bold margin-bottom-5">SmartAdmin Skins</h6>

          <section id="smart-styles">
            {
              config.skins.map((skin) => {
                const check = this.props.smartSkin == skin.name ? <i className="fa fa-check fa-fw"/> : '';
                const beta = skin.beta ? <sup>beta</sup> : '';
                return <a onClick={this.props.onSmartSkin.bind(this, skin)} className={skin.class}
                          style={skin.style} key={skin.name}>{check} {skin.label} {beta}</a>
              })
            }
          </section>
        </form>
      </div>
    )
  }
}


const mapStateToProps = (state, ownProps) => (state.layout);

function mapDispatchToProps(dispatch) {
  return bindActionCreators(LayoutActions, dispatch)
}

export default connect(mapStateToProps, mapDispatchToProps)(LayoutSwitcher)
