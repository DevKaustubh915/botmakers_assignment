import React from 'react'
import { useNavigate } from 'react-router-dom'

const HomePage = () => {

  const navigate = useNavigate()

  return (
    <div className=' h-screen w-screen flex items-center justify-center bg-gray-200 px-10 py-20'>
        <div className='h-full w-1/2 bg-white rounded-2xl text-center p-5 flex flex-col gap-20'>
          <div className='flex flex-col gap-5'>
            <h2 className='text-3xl text-gray-400'>Hello, I am Kaustubh</h2>
            <h3 className='text-gray-400'>Welcome to assignment project</h3>
            <h1 className='text-5xl font-medium'>RBAC SYSTEM</h1>
            <h4>Register , Login and acess content based on your role.</h4>

          </div>
              
          <div className='flex justify-evenly'>
            <button onClick={()=>{navigate('/signup')}} className='bg-blue-400 hover:bg-blue-600 w-50 px-5 py-3 rounded-2xl '>SignUp</button>
            <button onClick={()=>{navigate('/login')}} className='bg-blue-400 hover:bg-blue-600 w-50 px-5 py-3 rounded-2xl '>LogIn</button>
          </div>
        </div>
    </div>
  )
}

export default HomePage