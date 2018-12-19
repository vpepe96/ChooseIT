import React from 'react'
import Msg from '../i18n/Msg'


export default class RecentProjects extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            projects: [
                {
                    "href": "/",
                    "title": "Online e-merchant management system - attaching integration with the iOS"
                },
                {
                    "href": "/",
                    "title": "Notes on pipeline upgradee"
                },
                {
                    "href": "/",
                    "title": "Assesment Report for merchant account"
                }
            ]
        }
    }
    _clearProjects = ()=>{
        this.setState({
            projects: []
        })
    }
    render() {
        let projects = this.state.projects;
        return (
            <div className="project-context hidden-xs dropdown">

                <span className="label">
                    <Msg phrase="Projects" />
                </span>
                <span className="project-selector dropdown-toggle" data-toggle="dropdown">
                    <Msg phrase="Recent projects" />
                    { projects.length ?
                        <i  className="fa fa-angle-down"/>
                            : null }
                </span>

                { projects.length ?
                    <ul className="dropdown-menu">
                        {projects.map(function(project, idx){
                            return (
                                <li key={idx}>
                                    <a href={project.href}>{project.title}</a>
                                </li>)
                        })}

                        <li className="divider"/>
                        <li>
                            <a onClick={this._clearProjects}><i className="fa fa-power-off"/> Clear</a>
                        </li>
                    </ul> : null}

            </div>
        )
    }
}