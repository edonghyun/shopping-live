<script lang="ts">
  import { Container, Row } from 'sveltestrap';
  import { Router, Route } from "svelte-navigator";

  import Header from "./components/Header.svelte";
  import Home from "./pages/Home.svelte";
  import Login from "./pages/Login.svelte";
  import Register from "./pages/Register.svelte";
</script>

<Router>
    <Container class="p-0" fluid>
        <Header />
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
