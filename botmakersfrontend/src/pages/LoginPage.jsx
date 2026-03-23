import React, { useState } from 'react'
import { loginUser } from '../services/Authservice'
import toast from 'react-hot-toast'
import { useNavigate } from 'react-router-dom'

const LoginPage = () => {

    const [form, setForm] = useState({
        email: '',
        password: '',
    })

    const [loading, setLoading] = useState(false)

    const navigate = useNavigate()

    const onChangeHandler = (e) => {

        const { name, value } = e.target;

        setForm((prev) => ({
            ...prev,
            [name]: value,
        }));
    };

    const onSubmitHandler = async (e) => {
        e.preventDefault()

        try {
            setLoading(true)
            console.log("setted loading to true")

            const response = await loginUser(form);
            console.log("backed called")


            localStorage.setItem('token', response.token);
            console.log("token stored")

            localStorage.setItem(
                "user",
                JSON.stringify({
                    id: response.id,
                    name: response.name,
                    email: response.email,
                    role: response.role,
                })
            );
            console.log("user stored")

            toast.success("login sucessfull")
            console.log(response)

        

            setForm({
                email: '',
                password: '',
            });

            if (response.role === "ADMIN") {
                navigate("/admin/dashboard");
            } else if (response.role === "USER") {
                navigate("/user/dashboard");
            } else {
                navigate("/");
            }


        } catch {
            toast.error("login failed")
        } finally {
            setLoading(false)
        }
    }


    return (
        <div className='h-screen w-screen bg-gray-200 flex items-center justify-center'>
            <div className='bg-white h-2/3 w-2/5 rounded-2xl flex flex-col gap-10 px-5 py-2'>
                <div className='flex items-center justify-center'>
                    <h1 className='text-5xl font-medium'>Login</h1>
                </div>

                <form onSubmit={onSubmitHandler} className='flex flex-col'>
                    <h2>Email</h2>
                    <input
                    name='email'
                    value={form.email}
                    onChange={onChangeHandler}
                    className='bg-gray-200 outline-none rounded-2xl p-2' type="email" placeholder='Enter your email..' />
                    
                    <h2 className='mt-5'>Password</h2>
                    <input
                    name='password'
                    value={form.password}
                    onChange={onChangeHandler}
                    className='bg-gray-200 outline-none rounded-2xl p-2' type="password" placeholder='Enter your password' />
                    <button
                    type='submit'
                    disabled={loading}
                    className='bg-blue-400 hover:bg-blue-600 outline-none rounded-2xl p-2 mt-10'>{loading ? "loading..." : "Log in"}</button>
                </form>

            </div>
        </div>
    )
}

export default LoginPage