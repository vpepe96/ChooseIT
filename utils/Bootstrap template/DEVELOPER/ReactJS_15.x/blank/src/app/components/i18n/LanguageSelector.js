import React from 'react'
import Reflux from 'reflux'
import classnames from 'classnames'
import LanguageActions from './LanguageActions'
import LanguageStore from './LanguageStore'

export default class LanguageSelector extends Reflux.Component{
    constructor(props)
    {
      super(props);
      this.state = {}; // our store will add its own state to the component's
      this.store = LanguageStore; // <- just assign the store class itself
    }
    render () {

        let languages = this.state.languages;
        let language = this.state.language;
        if(!this.state.language) return <div/>
        return (
            <ul className="header-dropdown-list hidden-xs ng-cloak">
                <li className="dropdown">
                    <a className="dropdown-toggle" href="#"  data-toggle="dropdown">
                        <img src="assets/img/blank.gif"
                             className={classnames(['flag', 'flag-'+language.key])} alt={language.alt} />
                        <span>&nbsp;{language.title}&nbsp;</span>
                        <i className="fa fa-angle-down" /></a>
                    <ul className="dropdown-menu pull-right">
                        {languages.map((_lang, idx)=>{
                            return (
                                <li key={idx} className={classnames({
                                    active: _lang.key == language.key
                                })}>
                                    <a href="#" onClick={this._selectLanguage.bind(this, _lang)} >
                                        <img src="assets/img/blank.gif"
                                             className={classnames(['flag', 'flag-'+_lang.key])} alt={_lang.alt} />
                                        <span>&nbsp;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               {_lang.title}</span>
                                    </a>
                                </li>
                            )
                        })}
                    </ul>
                </li>
            </ul>
        )
    }
    _selectLanguage(language){

        LanguageActions.select(language)
    }
}
