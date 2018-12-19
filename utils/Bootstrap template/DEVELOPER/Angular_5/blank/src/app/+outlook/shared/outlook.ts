export interface Space {
  free:string
  total:string
  ratio:number
}

export interface Label {
  label:string
  name:string
  color:string
  count:number
}

export class Folder {
  key:string;
  name:string;
  total:number;
  unread:number;
  labels:Array<Label>
}

export class Outlook {
  folders:Array<Folder>;
  labels:Array<Label>;
  space:Space
}
