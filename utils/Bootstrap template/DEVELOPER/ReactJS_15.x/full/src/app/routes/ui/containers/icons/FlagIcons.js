import React from 'react'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../../components'

export default class FlagIcons extends React.Component {
  state = {
    search: ''
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (this.state.search != nextState.search) {
      let $container = $(this.refs.demoContainer);
      if (nextState.search) {
        $(".demo-icon-font", $container).hide();

        $(".demo-icon-font img", $container)
          .filter(function () {
            var r = new RegExp(nextState.search, 'i');
            return r.test($(this).attr('class') + $(this).attr('alt'))
          })
          .closest(".demo-icon-font").show();
        $(".alert, h2", $container).hide()
      } else {
        $(".demo-icon-font", $container).show();
        $(".alert, h2", $container).show()
      }
    }
    return true
  }

  onSearchChange = (value)=> {
    this.setState({
      search: value
    })
  }

  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['UI Elements', 'Icons', 'Flags']} icon="fa fa-fw fa-flag"
                          className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>

        {/* widget grid */}

        <WidgetGrid>

          <div className="well well-sm">
            <div className="input-group">
              <input className="form-control input-lg"
                     value={this.state.search}
                     onChange={event => this.onSearchChange(event.target.value)}
                     placeholder="Search for an icon..."/>
              <span className="input-group-addon"><i className="fa fa-fw fa-lg fa-search"/></span>
            </div>
          </div>

          {/* row */}
          {/* row */}
          <div className="row">

            {/* NEW WIDGET START */}
            <article className="col-sm-12">

              {/* Widget ID (each widget will need unique ID)*/}
              <JarvisWidget colorbutton={false} editbutton={false} togglebutton={false}
                            deletebutton={false} color="purple">

                <header>
                  <h2>World Flag </h2>
                </header>

                {/* widget div*/}
                <div>


                  {/* widget content */}
                  <div className="widget-body" ref="demoContainer">
                    <div className="alert alert-info">
                      <i className="fa fa-exclamation"/> Please note: flag images has a base class
                      for image <code>
                      flag flag-*</code>. A full example of this in use will be as follows: <code>
                      img class=&quot;flag flag-us&quot;
                      src=&quot;img/blank.gif&quot;</code>
                    </div>
                    <h2 >Africa</h2>

                    <div className="row">

                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-dz" src="assets/img/blank.gif" alt="Algeria"/>
                        Algeria
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ao" src="assets/img/blank.gif" alt="Angola"/>
                        Angola
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bj" src="assets/img/blank.gif" alt="Benin"/>
                        Benin
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bw" src="assets/img/blank.gif"
                             alt="Botswana"/> Botswana
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bf" src="assets/img/blank.gif"
                             alt="Burkina Faso"/> Burkina Faso
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bi" src="assets/img/blank.gif" alt="Burundi"/>
                        Burundi
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cm" src="assets/img/blank.gif"
                             alt="Cameroon"/> Cameroon
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cv" src="assets/img/blank.gif"
                             alt="Cape Verde"/> Cape Verde
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cf" src="assets/img/blank.gif"
                             alt="Central African Republic"/> Central African Republic
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-td" src="assets/img/blank.gif" alt="Chad"/>
                        Chad
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-km" src="assets/img/blank.gif" alt="Comoros"/>
                        Comoros
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cg" src="assets/img/blank.gif" alt="Congo"/>
                        Congo
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cd" src="assets/img/blank.gif"
                             alt="Congo, The Democratic Republic of the"/> Congo, The Democratic
                        Republic of the
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ci" src="assets/img/blank.gif"
                             alt="C&#xF4;te d'Ivoire"/> C&#xF4;te d'Ivoire
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-dj" src="assets/img/blank.gif"
                             alt="Djibouti"/> Djibouti
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-eg" src="assets/img/blank.gif" alt="Egypt"/>
                        Egypt
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gq" src="assets/img/blank.gif"
                             alt="Equatorial Guinea"/> Equatorial Guinea
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-er" src="assets/img/blank.gif" alt="Eritrea"/>
                        Eritrea
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-et" src="assets/img/blank.gif"
                             alt="Ethiopia"/> Ethiopia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ga" src="assets/img/blank.gif" alt="Gabon"/>
                        Gabon
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gm" src="assets/img/blank.gif" alt="Gambia"/>
                        Gambia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gh" src="assets/img/blank.gif" alt="Ghana"/>
                        Ghana
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gn" src="assets/img/blank.gif" alt="Guinea"/>
                        Guinea
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gw" src="assets/img/blank.gif"
                             alt="Guinea-Bissau"/> Guinea-Bissau
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ke" src="assets/img/blank.gif" alt="Kenya"/>
                        Kenya
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ls" src="assets/img/blank.gif" alt="Lesotho"/>
                        Lesotho
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lr" src="assets/img/blank.gif" alt="Liberia"/>
                        Liberia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ly" src="assets/img/blank.gif" alt="Libya"/>
                        Libya
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mg" src="assets/img/blank.gif"
                             alt="Madagascar"/> Madagascar
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mw" src="assets/img/blank.gif" alt="Malawi"/>
                        Malawi
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ml" src="assets/img/blank.gif" alt="Mali"/>
                        Mali
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mr" src="assets/img/blank.gif"
                             alt="Mauritania"/> Mauritania
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mu" src="assets/img/blank.gif"
                             alt="Mauritius"/> Mauritius
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-yt" src="assets/img/blank.gif" alt="Mayotte"/>
                        Mayotte
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ma" src="assets/img/blank.gif" alt="Morocco"/>
                        Morocco
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mz" src="assets/img/blank.gif"
                             alt="Mozambique"/> Mozambique
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-na" src="assets/img/blank.gif" alt="Namibia"/>
                        Namibia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ne" src="assets/img/blank.gif" alt="Niger"/>
                        Niger
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ng" src="assets/img/blank.gif" alt="Nigeria"/>
                        Nigeria
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-rw" src="assets/img/blank.gif" alt="Rwanda"/>
                        Rwanda
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-re" src="assets/img/blank.gif"
                             alt="R&#xE9;union"/> R&#xE9;union
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sh" src="assets/img/blank.gif"
                             alt="Saint Helena"/> Saint Helena
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-st" src="assets/img/blank.gif"
                             alt="Sao Tome and Principe"/> Sao Tome and Principe
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sn" src="assets/img/blank.gif" alt="Senegal"/>
                        Senegal
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sc" src="assets/img/blank.gif"
                             alt="Seychelles"/> Seychelles
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sl" src="assets/img/blank.gif"
                             alt="Sierra Leone"/> Sierra Leone
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-so" src="assets/img/blank.gif" alt="Somalia"/>
                        Somalia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-za" src="assets/img/blank.gif"
                             alt="South Africa"/> South Africa
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ss" src="assets/img/blank.gif"
                             alt="South Sudan"/> South Sudan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sd" src="assets/img/blank.gif" alt="Sudan"/>
                        Sudan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sz" src="assets/img/blank.gif"
                             alt="Swaziland"/> Swaziland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tz" src="assets/img/blank.gif"
                             alt="Tanzania"/> Tanzania
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tg" src="assets/img/blank.gif" alt="Togo"/>
                        Togo
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tn" src="assets/img/blank.gif" alt="Tunisia"/>
                        Tunisia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ug" src="assets/img/blank.gif" alt="Uganda"/>
                        Uganda
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-eh" src="assets/img/blank.gif"
                             alt="Western Sahara"/> Western Sahara
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-zm" src="assets/img/blank.gif" alt="Zambia"/>
                        Zambia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-zw" src="assets/img/blank.gif"
                             alt="Zimbabwe"/> Zimbabwe
                      </div>
                    </div>

                    <h2 >America</h2>

                    <div className="row">

                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ai" src="assets/img/blank.gif"
                             alt="Anguilla"/> Anguilla
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ag" src="assets/img/blank.gif"
                             alt="Antigua and Barbuda"/> Antigua and Barbuda
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ar" src="assets/img/blank.gif"
                             alt="Argentina"/> Argentina
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-aw" src="assets/img/blank.gif" alt="Aruba"/>
                        Aruba
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bs" src="assets/img/blank.gif" alt="Bahamas"/>
                        Bahamas
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bb" src="assets/img/blank.gif"
                             alt="Barbados"/> Barbados
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bz" src="assets/img/blank.gif" alt="Belize"/>
                        Belize
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bm" src="assets/img/blank.gif" alt="Bermuda"/>
                        Bermuda
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bo" src="assets/img/blank.gif"
                             alt="Bolivia, Plurinational State of"/> Bolivia, Plurinational
                        State of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-br" src="assets/img/blank.gif" alt="Brazil"/>
                        Brazil
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ca" src="assets/img/blank.gif" alt="Canada"/>
                        Canada
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ky" src="assets/img/blank.gif"
                             alt="Cayman Islands"/> Cayman Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cl" src="assets/img/blank.gif" alt="Chile"/>
                        Chile
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-co" src="assets/img/blank.gif"
                             alt="Colombia"/> Colombia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cr" src="assets/img/blank.gif"
                             alt="Costa Rica"/> Costa Rica
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cu" src="assets/img/blank.gif" alt="Cuba"/>
                        Cuba
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cw" src="assets/img/blank.gif"
                             alt="Cura&#xE7;ao"/> Cura&#xE7;ao
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-dm" src="assets/img/blank.gif"
                             alt="Dominica"/> Dominica
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-do" src="assets/img/blank.gif"
                             alt="Dominican Republic"/> Dominican Republic
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ec" src="assets/img/blank.gif" alt="Ecuador"/>
                        Ecuador
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sv" src="assets/img/blank.gif"
                             alt="El Salvador"/> El Salvador
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fk" src="assets/img/blank.gif"
                             alt="Falkland Islands (Malvinas)"/> Falkland Islands (Malvinas)
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gf" src="assets/img/blank.gif"
                             alt="French Guiana"/> French Guiana
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gl" src="assets/img/blank.gif"
                             alt="Greenland"/> Greenland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gd" src="assets/img/blank.gif" alt="Grenada"/>
                        Grenada
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gp" src="assets/img/blank.gif"
                             alt="Guadeloupe"/> Guadeloupe
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gt" src="assets/img/blank.gif"
                             alt="Guatemala"/> Guatemala
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gy" src="assets/img/blank.gif" alt="Guyana"/>
                        Guyana
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ht" src="assets/img/blank.gif" alt="Haiti"/>
                        Haiti
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-hn" src="assets/img/blank.gif"
                             alt="Honduras"/> Honduras
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-jm" src="assets/img/blank.gif" alt="Jamaica"/>
                        Jamaica
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mq" src="assets/img/blank.gif"
                             alt="Martinique"/> Martinique
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mx" src="assets/img/blank.gif" alt="Mexico"/>
                        Mexico
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ms" src="assets/img/blank.gif"
                             alt="Montserrat"/> Montserrat
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-an" src="assets/img/blank.gif"
                             alt="Netherlands Antilles"/> Netherlands Antilles
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ni" src="assets/img/blank.gif"
                             alt="Nicaragua"/> Nicaragua
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pa" src="assets/img/blank.gif" alt="Panama"/>
                        Panama
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-py" src="assets/img/blank.gif"
                             alt="Paraguay"/> Paraguay
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pe" src="assets/img/blank.gif" alt="Peru"/>
                        Peru
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pr" src="assets/img/blank.gif"
                             alt="Puerto Rico"/> Puerto Rico
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kn" src="assets/img/blank.gif"
                             alt="Saint Kitts and Nevis"/> Saint Kitts and Nevis
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lc" src="assets/img/blank.gif"
                             alt="Saint Lucia"/> Saint Lucia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pm" src="assets/img/blank.gif"
                             alt="Saint Pierre and Miquelon"/> Saint Pierre and Miquelon
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-vc" src="assets/img/blank.gif"
                             alt="Saint Vincent and the Grenadines"/> Saint Vincent and the
                        Grenadines
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sx" src="assets/img/blank.gif"
                             alt="Sint Maarten"/> Sint Maarten
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sr" src="assets/img/blank.gif"
                             alt="Suriname"/> Suriname
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tt" src="assets/img/blank.gif"
                             alt="Trinidad and Tobago"/> Trinidad and Tobago
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tc" src="assets/img/blank.gif"
                             alt="Turks and Caicos Islands"/> Turks and Caicos Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-us" src="assets/img/blank.gif"
                             alt="United States"/> United States
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-uy" src="assets/img/blank.gif" alt="Uruguay"/>
                        Uruguay
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ve" src="assets/img/blank.gif"
                             alt="Venezuela, Bolivarian Republic of"/> Venezuela, Bolivarian
                        Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-vg" src="assets/img/blank.gif"
                             alt="Virgin Islands, British"/> Virgin Islands, British
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-vi" src="assets/img/blank.gif"
                             alt="Virgin Islands, U.S."/> Virgin Islands, U.S.
                      </div>
                    </div>


                    <h2 >Asia</h2>

                    <div className="row">
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-af" src="assets/img/blank.gif"
                             alt="Afghanistan"/> Afghanistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-am" src="assets/img/blank.gif" alt="Armenia"/>
                        Armenia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-az" src="assets/img/blank.gif"
                             alt="Azerbaijan"/> Azerbaijan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bh" src="assets/img/blank.gif" alt="Bahrain"/>
                        Bahrain
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bd" src="assets/img/blank.gif"
                             alt="Bangladesh"/> Bangladesh
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bt" src="assets/img/blank.gif" alt="Bhutan"/>
                        Bhutan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bn" src="assets/img/blank.gif"
                             alt="Brunei Darussalam"/> Brunei Darussalam
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kh" src="assets/img/blank.gif"
                             alt="Cambodia"/> Cambodia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cn" src="assets/img/blank.gif" alt="China"/>
                        China
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cy" src="assets/img/blank.gif" alt="Cyprus"/>
                        Cyprus
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ge" src="assets/img/blank.gif" alt="Georgia"/>
                        Georgia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-hk" src="assets/img/blank.gif"
                             alt="Hong Kong"/> Hong Kong
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-in" src="assets/img/blank.gif" alt="India"/>
                        India
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-id" src="assets/img/blank.gif"
                             alt="Indonesia"/> Indonesia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ir" src="assets/img/blank.gif"
                             alt="Iran, Islamic Republic of"/> Iran, Islamic Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-iq" src="assets/img/blank.gif" alt="Iraq"/>
                        Iraq
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-il" src="assets/img/blank.gif" alt="Israel"/>
                        Israel
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-jp" src="assets/img/blank.gif" alt="Japan"/>
                        Japan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-jo" src="assets/img/blank.gif" alt="Jordan"/>
                        Jordan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kz" src="assets/img/blank.gif"
                             alt="Kazakhstan"/> Kazakhstan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kp" src="assets/img/blank.gif"
                             alt="Korea, Democratic People's Republic of"/> Korea, Democratic
                        People's Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kr" src="assets/img/blank.gif"
                             alt="Korea, Republic of"/> Korea, Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kw" src="assets/img/blank.gif" alt="Kuwait"/>
                        Kuwait
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kg" src="assets/img/blank.gif"
                             alt="Kyrgyzstan"/> Kyrgyzstan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-la" src="assets/img/blank.gif"
                             alt="Lao People's Democratic Republic"/> Lao People's Democratic
                        Republic
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lb" src="assets/img/blank.gif" alt="Lebanon"/>
                        Lebanon
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mo" src="assets/img/blank.gif" alt="Macao"/>
                        Macao
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-my" src="assets/img/blank.gif"
                             alt="Malaysia"/> Malaysia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mv" src="assets/img/blank.gif"
                             alt="Maldives"/> Maldives
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mn" src="assets/img/blank.gif"
                             alt="Mongolia"/> Mongolia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mm" src="assets/img/blank.gif" alt="Myanmar"/>
                        Myanmar
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-np" src="assets/img/blank.gif" alt="Nepal"/>
                        Nepal
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-om" src="assets/img/blank.gif" alt="Oman"/>
                        Oman
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pk" src="assets/img/blank.gif"
                             alt="Pakistan"/> Pakistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ps" src="assets/img/blank.gif"
                             alt="Palestinian Territory, Occupied"/> Palestinian Territory,
                        Occupied
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ph" src="assets/img/blank.gif"
                             alt="Philippines"/> Philippines
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-qa" src="assets/img/blank.gif" alt="Qatar"/>
                        Qatar
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sa" src="assets/img/blank.gif"
                             alt="Saudi Arabia"/> Saudi Arabia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sg" src="assets/img/blank.gif"
                             alt="Singapore"/> Singapore
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lk" src="assets/img/blank.gif"
                             alt="Sri Lanka"/> Sri Lanka
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sy" src="assets/img/blank.gif"
                             alt="Syrian Arab Republic"/> Syrian Arab Republic
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tw" src="assets/img/blank.gif"
                             alt="Taiwan, Province of China"/> Taiwan, Province of China
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tj" src="assets/img/blank.gif"
                             alt="Tajikistan"/> Tajikistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-th" src="assets/img/blank.gif"
                             alt="Thailand"/> Thailand
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tl" src="assets/img/blank.gif"
                             alt="Timor-Leste"/> Timor-Leste
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tr" src="assets/img/blank.gif" alt="Turkey"/>
                        Turkey
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tm" src="assets/img/blank.gif"
                             alt="Turkmenistan"/> Turkmenistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ae" src="assets/img/blank.gif"
                             alt="United Arab Emirates"/> United Arab Emirates
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-uz" src="assets/img/blank.gif"
                             alt="Uzbekistan"/> Uzbekistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-vn" src="assets/img/blank.gif"
                             alt="Viet Nam"/> Viet Nam
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ye" src="assets/img/blank.gif" alt="Yemen"/>
                        Yemen
                      </div>
                    </div>

                    <h2 >Australia and Oceania</h2>

                    <div className="row">

                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-as" src="assets/img/blank.gif"
                             alt="American Samoa"/> American Samoa
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-au" src="assets/img/blank.gif"
                             alt="Australia"/> Australia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ck" src="assets/img/blank.gif"
                             alt="Cook Islands"/> Cook Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fj" src="assets/img/blank.gif" alt="Fiji"/>
                        Fiji
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pf" src="assets/img/blank.gif"
                             alt="French Polynesia"/> French Polynesia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gu" src="assets/img/blank.gif" alt="Guam"/>
                        Guam
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ki" src="assets/img/blank.gif"
                             alt="Kiribati"/> Kiribati
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mh" src="assets/img/blank.gif"
                             alt="Marshall Islands"/> Marshall Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fm" src="assets/img/blank.gif"
                             alt="Micronesia, Federated States of"/> Micronesia, Federated
                        States of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nr" src="assets/img/blank.gif" alt="Nauru"/>
                        Nauru
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nc" src="assets/img/blank.gif"
                             alt="New Caledonia"/> New Caledonia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nz" src="assets/img/blank.gif"
                             alt="New Zealand"/> New Zealand
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nu" src="assets/img/blank.gif" alt="Niue"/>
                        Niue
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nf" src="assets/img/blank.gif"
                             alt="Norfolk Island"/> Norfolk Island
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mp" src="assets/img/blank.gif"
                             alt="Northern Mariana Islands"/> Northern Mariana Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pw" src="assets/img/blank.gif" alt="Palau"/>
                        Palau
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pg" src="assets/img/blank.gif"
                             alt="Papua New Guinea"/> Papua New Guinea
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pn" src="assets/img/blank.gif"
                             alt="Pitcairn"/> Pitcairn
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ws" src="assets/img/blank.gif" alt="Samoa"/>
                        Samoa
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sb" src="assets/img/blank.gif"
                             alt="Solomon Islands"/> Solomon Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tk" src="assets/img/blank.gif" alt="Tokelau"/>
                        Tokelau
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-to" src="assets/img/blank.gif" alt="Tonga"/>
                        Tonga
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tv" src="assets/img/blank.gif" alt="Tuvalu"/>
                        Tuvalu
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-vu" src="assets/img/blank.gif" alt="Vanuatu"/>
                        Vanuatu
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-wf" src="assets/img/blank.gif"
                             alt="Wallis and Futuna"/> Wallis and Futuna
                      </div>

                    </div>

                    <h2 >Europe</h2>

                    <div className="row">

                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-al" src="assets/img/blank.gif" alt="Albania"/>
                        Albania
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ad" src="assets/img/blank.gif" alt="Andorra"/>
                        Andorra
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-at" src="assets/img/blank.gif" alt="Austria"/>
                        Austria
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-by" src="assets/img/blank.gif" alt="Belarus"/>
                        Belarus
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-be" src="assets/img/blank.gif" alt="Belgium"/>
                        Belgium
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ba" src="assets/img/blank.gif"
                             alt="Bosnia and Herzegovina"/> Bosnia and Herzegovina
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bg" src="assets/img/blank.gif"
                             alt="Bulgaria"/> Bulgaria
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-hr" src="assets/img/blank.gif" alt="Croatia"/>
                        Croatia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-cz" src="assets/img/blank.gif"
                             alt="Czech Republic"/> Czech Republic
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-dk" src="assets/img/blank.gif" alt="Denmark"/>
                        Denmark
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ee" src="assets/img/blank.gif" alt="Estonia"/>
                        Estonia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fo" src="assets/img/blank.gif"
                             alt="Faroe Islands"/> Faroe Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fi" src="assets/img/blank.gif" alt="Finland"/>
                        Finland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-fr" src="assets/img/blank.gif" alt="France"/>
                        France
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-de" src="assets/img/blank.gif" alt="Germany"/>
                        Germany
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gi" src="assets/img/blank.gif"
                             alt="Gibraltar"/> Gibraltar
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gr" src="assets/img/blank.gif" alt="Greece"/>
                        Greece
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-va" src="assets/img/blank.gif"
                             alt="Holy See (Vatican City State)"/> Holy See (Vatican City State)
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-hu" src="assets/img/blank.gif" alt="Hungary"/>
                        Hungary
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-is" src="assets/img/blank.gif" alt="Iceland"/>
                        Iceland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ie" src="assets/img/blank.gif" alt="Ireland"/>
                        Ireland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-it" src="assets/img/blank.gif" alt="Italy"/>
                        Italy
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lv" src="assets/img/blank.gif" alt="Latvia"/>
                        Latvia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-li" src="assets/img/blank.gif"
                             alt="Liechtenstein"/> Liechtenstein
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lt" src="assets/img/blank.gif"
                             alt="Lithuania"/> Lithuania
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-lu" src="assets/img/blank.gif"
                             alt="Luxembourg"/> Luxembourg
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mk" src="assets/img/blank.gif"
                             alt="Macedonia, The Former Yugoslav Republic of"/> Macedonia, The
                        Former Yugoslav Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mt" src="assets/img/blank.gif" alt="Malta"/>
                        Malta
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-md" src="assets/img/blank.gif"
                             alt="Moldova, Republic of"/> Moldova, Republic of
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-mc" src="assets/img/blank.gif" alt="Monaco"/>
                        Monaco
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-me" src="assets/img/blank.gif"
                             alt="Montenegro"/> Montenegro
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-nl" src="assets/img/blank.gif"
                             alt="Netherlands"/> Netherlands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-no" src="assets/img/blank.gif" alt="Norway"/>
                        Norway
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pl" src="assets/img/blank.gif" alt="Poland"/>
                        Poland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-pt" src="assets/img/blank.gif"
                             alt="Portugal"/> Portugal
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ro" src="assets/img/blank.gif" alt="Romania"/>
                        Romania
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ru" src="assets/img/blank.gif"
                             alt="Russian Federation"/> Russian Federation
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sm" src="assets/img/blank.gif"
                             alt="San Marino"/> San Marino
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-rs" src="assets/img/blank.gif" alt="Serbia"/>
                        Serbia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-sk" src="assets/img/blank.gif"
                             alt="Slovakia"/> Slovakia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-si" src="assets/img/blank.gif"
                             alt="Slovenia"/> Slovenia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-es" src="assets/img/blank.gif" alt="Spain"/>
                        Spain
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-se" src="assets/img/blank.gif" alt="Sweden"/>
                        Sweden
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ch" src="assets/img/blank.gif"
                             alt="Switzerland"/> Switzerland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ua" src="assets/img/blank.gif" alt="Ukraine"/>
                        Ukraine
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gb" src="assets/img/blank.gif"
                             alt="United Kingdom"/> United Kingdom
                      </div>
                    </div>

                    <h2 >Other areas</h2>

                    <div className="row">
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-bv" src="assets/img/blank.gif"
                             alt="Bouvet Island"/> Bouvet Island
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-io" src="assets/img/blank.gif"
                             alt="British Indian Ocean Territory"/> British Indian Ocean
                        Territory
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-ic" src="assets/img/blank.gif"
                             alt="Canary Islands"/> Canary Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-catalonia" src="assets/img/blank.gif"
                             alt="Catalonia"/> Catalonia
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-england" src="assets/img/blank.gif"
                             alt="England"/> England
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-eu" src="assets/img/blank.gif"
                             alt="European Union"/> European Union
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-tf" src="assets/img/blank.gif"
                             alt="French Southern Territories"/> French Southern Territories
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gg" src="assets/img/blank.gif"
                             alt="Guernsey"/> Guernsey
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-hm" src="assets/img/blank.gif"
                             alt="Heard Island and McDonald Islands"/> Heard Island and McDonald
                        Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-im" src="assets/img/blank.gif"
                             alt="Isle of Man"/> Isle of Man
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-je" src="assets/img/blank.gif" alt="Jersey"/>
                        Jersey
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-kurdistan" src="assets/img/blank.gif"
                             alt="Kurdistan"/> Kurdistan
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-scotland" src="assets/img/blank.gif"
                             alt="Scotland"/> Scotland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-somaliland" src="assets/img/blank.gif"
                             alt="Somaliland"/> Somaliland
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-gs" src="assets/img/blank.gif"
                             alt="South Georgia and the South Sandwich Islands"/> South Georgia
                        and the South Sandwich Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-um" src="assets/img/blank.gif"
                             alt="United States Minor Outlying Islands"/> United States Minor
                        Outlying Islands
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-wales" src="assets/img/blank.gif"
                             alt="Wales"/> Wales
                      </div>
                      <div className="col-xs-6 col-md-3 col-sm-4 demo-icon-font">
                        <img className="flag flag-zanzibar" src="assets/img/blank.gif"
                             alt="Zanzibar"/> Zanzibar
                      </div>

                    </div>


                  </div>
                  {/* end widget content */}

                </div>
                {/* end widget div */}

              </JarvisWidget>
              {/* end widget */}

            </article>
            {/* WIDGET END */}

          </div>

        </WidgetGrid>

      </div>
    )
  }
}