import axios from "axios";
import { AppConfig } from "./Constants";

export const request = axios.create({
  baseURL: AppConfig.apiUrl,
});