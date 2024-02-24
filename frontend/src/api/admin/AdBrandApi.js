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
}
