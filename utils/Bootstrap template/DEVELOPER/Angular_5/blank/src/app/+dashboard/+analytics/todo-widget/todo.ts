export class Todo {
  id: string;
  title: string;
  state: string;
  completedAt: any;
  createdAt: any;

  static _id = 0;

  constructor(title?, state?) {
    this.id = '' + Todo._id++;

    this.title = title;
    this.state = state;

    this.createdAt = new Date()
  }
}
