import axios from 'axios';
import React, { useEffect, useState } from 'react'

const UserProfile = () => {
   const [user, setUser] = useState(null)

  useEffect(() => {
    const getUser = async () => {
      try {
        const token = localStorage.getItem('token')

        const res = await axios.get('http://localhost:8080/api/user/profile', {
          headers: {
            Authorization: `Bearer ${token}`
          }
        })

        setUser(res.data)
      } catch (err) {
        console.error(err)
      }
    }

    getUser()
  }, [])

  return (
    <div className='p-5'>
      <h1 className='text-2xl font-bold mb-4'>User Profile</h1>

      {user ? (
        <div className='bg-gray-200 p-4 rounded-xl w-80'>
          <p><strong>Name:</strong> {user.name}</p>
          <p><strong>Email:</strong> {user.email}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  )
};


export default UserProfile