import { apiClient } from './client';

export async function getBroadcasts() {
    const { data } = await apiClient.get(
        '/broadcasts/',
    );
    console.log(data);
    return data;
}