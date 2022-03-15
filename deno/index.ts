import { serve } from "https://deno.land/std@0.126.0/http/server.ts";

console.log("http://localhost:8000/");

const res = await fetch("https://revenatium.com");
const body = new Uint8Array(await res.arrayBuffer());
await Deno.stdout.write(body);

serve((req) => new Response("Hello World\n"), { port: 8000 });
