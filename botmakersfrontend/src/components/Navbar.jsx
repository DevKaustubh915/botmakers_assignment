import React from 'react'
import { useNavigate } from 'react-router-dom'

const Navbar = () => {

    const navigate = useNavigate()

    const handleLogout = () => {
        localStorage.clear()
        navigate('/login')
    }

    const handleProfile = () => {
        navigate('/user/profile')
    }
    return (
        <div className='h-16 w-full bg-gray-300 px-5 flex items-center justify-between'>

            <div className='text-3xl font-medium'>
                <h2 >Kaustubh</h2>
            </div>
            <div className='flex gap-5'>
                <button
                type='click'
                onClick={handleProfile}
                className='h-10 w-20 flex items-center justify-center bg-purple-300 rounded-2xl font-medium'>profile</button>
                <button
                type='click'
                onClick={handleLogout}
                className='h-10 w-20 flex items-center justify-center bg-purple-300 rounded-2xl font-medium'>logout</button>
            </div>

        </div>
    )
}

export default Navbar