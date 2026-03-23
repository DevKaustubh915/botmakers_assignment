import React from 'react'
import Navbar from '../components/Navbar'

const UserDashboard = () => {
  return (
    <>
    <Navbar/>
    <div className='h-screen w-screen bg-white flex items-center justify-center'>
        <div className='flex items-center justify-center'>
            <h1 className='text-5xl font-medium'>Hello Welcome to UserDashboard</h1>
        </div>
    </div>
    </>
  )
}

export default UserDashboard