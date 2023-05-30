import logo from './logo.svg';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './view/home';
import About from './view/about';
import Axios from './view/axios';
import Profile from './view/profile';


function App() {
  return (
      <BrowserRouter>
        <nav>
          <Link to='/'>Home</Link>
          <br />
          <Link to='/about'>About</Link>
          <br />
          <Link to='/profile'>Profile</Link>
          <br />
          <Link to='/axios'>Axios</Link>
        </nav>
        <header>----------------------------------</header>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/profile" element={<Profile />} />
            <Route path="/axios" element={<Axios />} />
        </Routes>
        <footer>----------------------------------</footer>
      </BrowserRouter>
  );
}

export default App;
