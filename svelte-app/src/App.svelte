<script lang="ts">
  import { Container, Row, Navbar } from 'sveltestrap';
  import { Router, Route, Link } from "svelte-navigator";

  import Home from "./pages/Home.svelte";
  import Login from "./pages/Login.svelte";
  import Register from "./pages/Register.svelte";
</script>

<Router>
    <Container class="p-0" fluid>
        <Navbar
                color="dark"
                dark={true}
                light={false}
                class="mb-2"
        >
            <Link class="navbar-brand" to="/">HOME</Link>
            <div>
                <Link class="navbar-brand" to="/login">LOGIN</Link>
                <Link class="navbar-brand" to="/register">REGISTER</Link>
            </div>
        </Navbar>
        <Row class="p-3">
            <Route path="/">
                <Home />
            </Route>
            <Route path="/login">
                <Login />
            </Route>
            <Route path="/register">
                <Register />
            </Route>
        </Row>
    </Container>
</Router>
