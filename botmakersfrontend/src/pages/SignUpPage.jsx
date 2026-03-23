import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { registerUser } from '../services/Authservice'
import toast from 'react-hot-toast'

const SignUpPage = () => {

    const[form,setForm] = useState({
        name:'',
        email:'',
        password:'',
    })

    const[loading,setLoading] = useState(false)

    const navigate = useNavigate()

    const onChangeHandler = (e) =>{

        const{name, value} = e.target;

        setForm((prev)=>({
            ...prev,
            [name]:value,
        }));
    };

    const onSubmitHandler = async(e) => {
        e.preventDefault()

        try{
            setLoading(true)

            await registerUser(form);

            toast.success("Registration sucessfull")

            setForm({
                name:'',
                email:'',
                password:'',
            });

            navigate('/login')

        }catch{
            toast.error("Registration failed")
        }finally{
            setLoading(false)
        }
    }



  return (
    <div className='h-screen w-screen bg-gray-200 flex items-center justify-center'>
        <div className='bg-white h-2/3 w-2/5 rounded-2xl flex flex-col gap-6 px-5 py-2'>
            <div className='flex items-center justify-center'>
                <h1 className='text-5xl font-medium'>Create an account</h1>
            </div>

            <form onSubmit={onSubmitHandler} className='flex flex-col'>
                <h2>Name</h2>
                <input
                name='name'
                value={form.name}
                onChange={onChangeHandler}
                className='bg-gray-200 outline-none rounded-2xl p-2' type="text" placeholder='Enter your name..' />
                <h2>Email</h2>
                <input
                name='email'
                value={form.email}
                onChange={onChangeHandler}
                className='bg-gray-200 outline-none rounded-2xl p-2' type="email" placeholder='Enter your email..'  />
                <h2>Password</h2>
                <input
                name='password'
                value={form.password}
                onChange={onChangeHandler}
                className='bg-gray-200 outline-none rounded-2xl p-2' type="password" placeholder='Enter your password'  />
                <button
                type='submit'
                disabled={loading}
                className='bg-blue-400 hover:bg-blue-600 outline-none rounded-2xl p-2 mt-5'>{loading ? "loading..." : "Sign Up"}</button>
            </form>

        </div>
    </div>
  )
}

export default SignUpPage