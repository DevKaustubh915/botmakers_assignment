import React from 'react'
import HomePage from './pages/HomePage'
import { Route, Routes } from 'react-router-dom'
import SignUpPage from './pages/SignUpPage'
import LoginPage from './pages/LoginPage'
import UserDashboard from './pages/UserDashboard'
import AdminDashboard from './pages/AdminDashboard'
import UserProfile from './pages/UserProfile'


const App = () => {
  return (
    <Routes>
      <Route path='/' element={<HomePage />} />
      <Route path='/signup' element={<SignUpPage />} />
      <Route path='/login' element={<LoginPage />} />
      <Route path='/user/dashboard' element={<UserDashboard />} />
      <Route path='/user/profile' element={<UserProfile />} />
      <Route path='/admin/dashboard' element={<AdminDashboard />} />
    </Routes>
  )
}

export default App