import { apiProduct } from "../../config/apiConfig";
import { request } from "../../helper/request.helper";
export class AdProductApi {
  static getAll() {
    return request({
      method: "GET",
      url: apiProduct + "/getall",
    });
  }

  static getpage(filter) {
    return request({
      method: "GET",
      url: apiProduct + `?value=${filter.value}&page=${filter.page}`,
    });
  }

  static handelDetail(id) {
    return request({
      method: "Get",
      url: apiProduct + "/detail/" + id,
    });
  }

  static handelDelete(id) {
    return request({
      method: "Delete",
      url: apiProduct + "/delete/" + id,
    });
  }

  static handelUpdate(id, data) {
    return request({
      method: "put",
      url: apiProduct + "/update/" + id,
      data: data,
    });
  }

  static handelAdd(data) {
    return request({
      method: "post",
      url: apiProduct + "/add",
      data: data,
    });
  }
}
