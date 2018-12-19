import React from 'react'

export default class  SearchMobile extends React.Component{
    toggleSearch(e){
        $('body').addClass('search-mobile');
        e.preventDefault();
        $('#cancel-search-js').on('click', function (e) {
            $('body').removeClass('search-mobile');
            e.preventDefault();
        });
    }
    render () {
        return (
            <div id="search-mobile" className={this.props.className} >
                <span> <a onClick={this.toggleSearch} title="Search"><i className="fa fa-search"/></a> </span>
            </div>
        )
    }
}