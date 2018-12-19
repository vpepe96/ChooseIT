/**
 * Created by griga on 12/23/15.
 */

import Reflux from 'reflux'

import _ from 'lodash'

import moment from 'moment'

import TodoActions from '../actions/TodoActions'

let data = {
    items: [{
        "_id": "542d47f5e3355bf80ebdf83f",
        "type": "Critical",
        "title": "Inbox",
        "completedAt": null,
        "createdAt": moment().subtract(2, 'days')
    }, {
        "_id": "542d4835e3355bf80ebdf840",
        "type": "Important",
        "title": "Animations",
        "completedAt": null,
        "createdAt": moment().startOf('day')
    }, {
        "_id": "542d483ee3355bf80ebdf841",
        "type": "Important",
        "title": "Directives",
        "completedAt": null,
        "createdAt": moment().add(1, 'days')
    }],
    newTodo: undefined
};


export default class TodoStore extends Reflux.Store{

    constructor(){
        super();
        this.listenToMany(TodoActions)
    }

    static getData () {
        return data
    }
    static getItemById(id){
        return _.find(data.items, function(item){
            return item._id == id
        })
    }
    onDeleteTodo(item){
        data.items = _.without(data.items, item);
        this.trigger(data)
    }
    onToggleNewTodo(){
        data.newTodo = data.newTodo ? null : {};
        this.trigger(data)

    }
    onToggleTodo(todo){
        if (todo.completedAt){
            todo.completedAt = null;
            todo.type = 'Important'
        } else {
            todo.completedAt = moment();
            todo.type = 'Completed'
        }
        this.trigger(data)
    }
    onUpdateTodo(todo){
        switch (todo.type){
            case 'Critical':
                todo.completedAt = null;
                break;
            case 'Important':
                todo.completedAt = null;
                break;
            case 'Completed':
                todo.completedAt = moment();
                break

        }
        this.trigger(data)
    }
    onAddNewTodo(todo){
        todo.createdAt = moment();
        todo._id = _.uniqueId('todo-item-');
        data.items.push(todo);
        this.onToggleNewTodo()
    }
}