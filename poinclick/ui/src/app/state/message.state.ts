export enum MessageStateEnum {
  LOADING,
  LOADED,
  ERROR
}

export interface AppMessageState<T> {
  dataState?:MessageStateEnum,
  datase?:T,
  dataLength?:any,
  errorMessage?:string
}
