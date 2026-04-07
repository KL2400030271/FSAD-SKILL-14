import { useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("username");
    if (!user) navigate("/");
  }, []);

  const logout = () => {
    localStorage.removeItem("username");
    navigate("/");
  };

  return (
    <div>
      <h2>Home</h2>

      <Link to="/profile">Go to Profile</Link>
      <br /><br />

      <button onClick={logout}>Logout</button>
    </div>
  );
}

export default Home;