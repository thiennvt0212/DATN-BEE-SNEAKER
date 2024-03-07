import { apiSole } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";
export class AdSoleApi {
  static getAll() {
    return request({
      method: "GET",
      url: apiSole + "/getall",
    });
  }

  static getpage(filter) {
    return request({
      method: "GET",
      url: apiSole + `?value=${filter.value}&page=${filter.page}`,
    });
  }

  static handelDetail(id) {
    return request({
      method: "Get",
      url: apiSole + "/detail/" + id,
    });
  }

  static handelDelete(id){
    return request({
      method: "Delete",
      url: apiSole + "/delete/" + id,
    });
  }
  
  static handelUpdate(id, data){
    return request({
      method: "put",
      url: apiSole + "/update/" + id,
      data: data,
    });
  }

  static handelAdd(data){
    return request({
      method: "post",
      url: apiSole + "/add",
      data: data,
    });
  }
}