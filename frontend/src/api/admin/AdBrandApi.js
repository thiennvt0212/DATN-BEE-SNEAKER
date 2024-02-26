import { apiBrand } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";
export class AdBrandAPI {
  static getAll() {
    return request({
      method: "GET",
      url: apiBrand + "/getall",
    });
  }

  static handelDetail(id) {
    return request({
      method: "Get",
      url: apiBrand + "/detail/" + id,
    });
  }

  static handelDelete(id){
    return request({
      method: "Delete",
      url: apiBrand + "/delete/" + id,
    });
  }
  
  static handelUpdate(id, data){
    return request({
      method: "put",
      url: apiBrand + "/update/" + id,
      data: data,
    });
  }

  static handelAdd(data){
    return request({
      method: "post",
      url: apiBrand + "/add",
      data: data,
    });
  }
}
