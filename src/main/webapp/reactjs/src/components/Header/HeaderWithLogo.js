import React from "react";
import { Link } from "react-router-dom";
import "../../css/header-and-body.css";
import Menu from "./HeaderComponents/Menu";
import Logo from "./HeaderComponents/Logo";

function Header() {
  return (
    <div className="header">
        <Logo />
        <Menu />
    </div>
  );
}

export default Header;