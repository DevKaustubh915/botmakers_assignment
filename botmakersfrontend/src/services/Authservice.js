import api from "../api/axios";

export const registerUser = async (userData) => {
  const response = await api.post("/api/public/register", userData);
  return response.data;
};

export const loginUser = async (userData) => {
  const response = await api.post("/api/public/login", userData);
  return response.data;
};