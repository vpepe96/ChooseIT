import React from 'react'

import TodoActions from '../actions/TodoActions'

export default class TodoForm extends React.Component{
    constructor (props) {
        super(props);
        this.state = {
            title: '',
            type: 'Important'
        }
    }
    _addTodo = () => {
        TodoActions.addNewTodo(this.state)
    }
    _toggleAdd () {
        TodoActions.toggleNewTodo()
    }
    onTitleChange = (value)=>{
        this.setState({
            title: value
        })
    }
    onTypeChange = (value)=>{
        this.setState({
            type: value
        })
    }
    render () {
        return (
            <form name="newTodoForm" className="smart-form">
                <fieldset>
                    <section>
                        <label className="input">
                            <input type="text" required className="input-lg"
                                value={this.state.title}
                                onChange={event => this.onTitleChange(event.target.value)}
                                placeholder="What needs to be done?" />
                        </label>
                    </section>
                    <section>
                        <div className="col-xs-6">
                            <label className="select">
                                <select className="input-sm"
                                    value={this.state.type}
                                    onChange={event => this.onTypeChange(event.target.value)}>
                                    <option value="Critical">Critical</option>
                                    <option value="Important">Important</option>
                                    <option value="Completed">Completed</option>
                                </select>  </label>
                        </div>
                    </section>
                </fieldset>
                <footer>
                    <button type="button" className="btn btn-primary" onClick={this._addTodo}>
                        Add
                    </button>
                    <button type="button" className="btn btn-default" onClick={this._toggleAdd}>
                        Cancel
                    </button>
                </footer>
            </form>
        )
    }
}